// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.trajectory.Trajectory;
import edu.wpi.first.math.trajectory.TrajectoryConfig;
import edu.wpi.first.math.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Axis;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.Constants.AutoConstants;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.OIConstants;
import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ConveyorSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SwerveControllerCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

import java.util.List;

/*
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems
  //private final IntakeSubsystem intake = new IntakeSubsystem();
  //private final IntakeSubsystem shooter = new IntakeSubsystem();
  private final DriveSubsystem m_robotDrive = new DriveSubsystem();
  private final ShooterSubsystem m_ShooterSubsystem = new ShooterSubsystem();
  private final IntakeSubsystem m_IntakeSubsystem = new IntakeSubsystem();
  private final ClimberSubsystem m_ClimberSubsystem = new ClimberSubsystem();
  private final ConveyorSubsystem m_ConveyorSubsystem = new ConveyorSubsystem();

  // The driver's controller
  XboxController controller1 = new XboxController(OIConstants.kDriverControllerPort);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    m_robotDrive.setDefaultCommand(
        // The left stick controls translation of the robot.
        // Turning is controlled by the X axis of the right stick.
        new RunCommand(
            () -> m_robotDrive.drive(
                -MathUtil.applyDeadband(controller1.getLeftY(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(controller1.getLeftX(), OIConstants.kDriveDeadband),
                -MathUtil.applyDeadband(controller1.getRightX(), OIConstants.kDriveDeadband),
                true, true),
            m_robotDrive));
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link edu.wpi.first.wpilibj.GenericHID} or one of its
   * subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then calling
   * passing it to a
   * {@link JoystickButton}.
   */
  private void configureButtonBindings() {
    new JoystickButton(controller1, Button.kX.value)
        .whileTrue(new RunCommand(() -> m_robotDrive.setX(),m_robotDrive));

      new JoystickButton(controller1, Button.kA.value)
        .whileTrue(new RunCommand(() -> m_IntakeSubsystem.startMotor(), m_IntakeSubsystem))
        .whileTrue(new RunCommand(() -> m_ConveyorSubsystem.halfForwardMotor(), m_ConveyorSubsystem))
        .whileFalse(new RunCommand(() -> m_IntakeSubsystem.stopMotor(), m_IntakeSubsystem))
         .whileFalse(new RunCommand(() -> m_ConveyorSubsystem.stopMotor(), m_ConveyorSubsystem));

        
      new JoystickButton(controller1, Button.kB.value)
        .whileTrue(new RunCommand(() -> m_ConveyorSubsystem.backwardsMotor(), m_ConveyorSubsystem))
        .whileFalse(new RunCommand(() -> m_ConveyorSubsystem.stopMotor(), m_ConveyorSubsystem));

        
      new JoystickButton(controller1, Button.kY.value)
        .whileTrue(new RunCommand(() -> m_ShooterSubsystem.startMotor(), m_ShooterSubsystem))
        .whileTrue(new RunCommand(() -> m_ConveyorSubsystem.forwardMotor(), m_ConveyorSubsystem))
        .whileFalse(new RunCommand(() -> m_ConveyorSubsystem.stopMotor(), m_ConveyorSubsystem))
        .whileFalse(new RunCommand(() -> m_ShooterSubsystem.stopMotor(), m_ShooterSubsystem));

      new JoystickButton(controller1, Axis.kRightTrigger.value)
      .whileTrue(new RunCommand(() -> m_ClimberSubsystem.climberRightUp(), m_ClimberSubsystem))
      .whileFalse(new RunCommand(() -> m_ClimberSubsystem.stopRightMotor(), m_ClimberSubsystem));

     
      new JoystickButton(controller1, Button.kRightBumper.value)
      .whileTrue(new RunCommand(() -> m_ClimberSubsystem.climberRightDown(), m_ClimberSubsystem))
      .whileFalse(new RunCommand(() -> m_ClimberSubsystem.stopRightMotor(), m_ClimberSubsystem));

      new JoystickButton(controller1, Axis.kLeftTrigger.value)
      .whileTrue(new RunCommand(() -> m_ClimberSubsystem.climberLeftUp(), m_ClimberSubsystem))
      .whileFalse(new RunCommand(() -> m_ClimberSubsystem.stopLeftMotor(), m_ClimberSubsystem));

      new JoystickButton(controller1, Button.kLeftBumper.value) 
      .whileTrue(new RunCommand(() -> m_ClimberSubsystem.climberLeftDown(), m_ClimberSubsystem))
      .whileFalse(new RunCommand(() -> m_ClimberSubsystem.stopLeftMotor(), m_ClimberSubsystem));
      }

      

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // Create config for trajectory
    TrajectoryConfig config = new TrajectoryConfig(
        AutoConstants.kMaxSpeedMetersPerSecond,
        AutoConstants.kMaxAccelerationMetersPerSecondSquared)
        // Add kinematics to ensure max speed is actually obeyed
        .setKinematics(DriveConstants.kDriveKinematics);
    // An example trajectory to follow. All units in meters.
    Trajectory exampleTrajectory = TrajectoryGenerator.generateTrajectory(
        // Start at the origin facing the +X direction
        new Pose2d(0, 0, new Rotation2d(0)),
        // Pass through these two interior waypoints, making an 's' curve path
        List.of(new Translation2d(-1, 0), new Translation2d(-2, new Rotation2d(-Math.PI/2))),
        // End 3 meters straight ahead of where we started, facing forward
        new Pose2d(-3, 0, new Rotation2d(0)),
        config.setReversed(true));

    var thetaController = new ProfiledPIDController(
        AutoConstants.kPThetaController, 0, 0, AutoConstants.kThetaControllerConstraints);
    thetaController.enableContinuousInput(-Math.PI, Math.PI);

    SwerveControllerCommand swerveControllerCommand = new SwerveControllerCommand(
        exampleTrajectory,
        m_robotDrive::getPose, // Functional interface to feed supplier
        DriveConstants.kDriveKinematics,

        // Position controllers
        new PIDController(AutoConstants.kPXController, 0, 0),
        new PIDController(AutoConstants.kPYController, 0, 0),
        thetaController,
        m_robotDrive::setModuleStates,
        m_robotDrive);

    // Reset odometry to the starting pose of the trajectory.
    m_robotDrive.resetOdometry(exampleTrajectory.getInitialPose());

    // Run path following command, then stop at the end.
    return swerveControllerCommand.andThen(() -> m_robotDrive.drive(0, 0, 0, false, false));
  }
}

