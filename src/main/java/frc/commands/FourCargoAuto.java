package frc.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.commands.ShooterCommand;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.Constants.AutoConstants;

public class FourCargoAuto extends SequentialCommandGroup {
    public FourCargoAuto(DriveSubsystem drive, IntakeSubsystem intake, ConveyorSubsystem conveyor, ShooterSubsystem shooter) {
        addCommands(
            // Drive forward the specified distance
            new ParallelCommandGroup(new ShooterCommand(shooter, conveyor).withTimeout(1.5)),
            new DriveCommand(drive, 2,  AutoConstants.kMaxSpeedMetersPerSecond, 0, 0));
      }
}
