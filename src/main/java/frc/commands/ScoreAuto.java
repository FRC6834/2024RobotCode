package frc.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.DriveSubsystem;

public class ScoreAuto extends Command{
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final ShooterSubsystem m_ShooterSubsystem;
    private final ConveyorSubsystem m_ConveyorSubsystem;

    public ScoreAuto(ShooterSubsystem subsystem, ConveyorSubsystem subsystem2){
        m_ShooterSubsystem = subsystem;
        m_ConveyorSubsystem = subsystem2;
        addRequirements(subsystem);
        addRequirements(subsystem2);
    }
    //called when the command is initialized
    @Override
    public void initialize(){
      new RunCommand(() -> m_ShooterSubsystem.startMotor(), m_ShooterSubsystem);
      new RunCommand(() -> m_ConveyorSubsystem.forwardMotor(), m_ConveyorSubsystem);
    }
    //called every time the command is scheduled
    @Override
    public void execute(){

    }

    @Override
    public void end(boolean interrupted){
      new RunCommand(() -> m_ShooterSubsystem.stopMotor(), m_ShooterSubsystem);
      new RunCommand(() -> m_ConveyorSubsystem.stopMotor(), m_ConveyorSubsystem);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
