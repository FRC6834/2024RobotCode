package frc.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.Constants.AutoConstants;

public class SimpleAuto extends SequentialCommandGroup{
    public SimpleAuto(DriveSubsystem drive){
      addCommands(
        new DriveCommand(drive, 0, 0, 0, 0)
      );  
    }
    
}
