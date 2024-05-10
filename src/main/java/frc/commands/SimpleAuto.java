package frc.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class SimpleAuto extends SequentialCommandGroup{
  /*since i can't test the code since im at my house rn i made a boolean for wether or not the robot will go for a second note 
  or if it will just leave the starting area after shooting the preloaded note. if going for a 2nd note causes problems set this to false*/
  boolean secondNote = true;
    public SimpleAuto(DriveSubsystem drive, IntakeSubsystem intake, ConveyorSubsystem conveyor, ShooterSubsystem shooter){

      //!!UNTESTED!!

      if(secondNote==true){
        addCommands(

          //shoots preloaded note
          new ParallelCommandGroup(new ShooterCommand(shooter, conveyor)),

          //collects second note; drives backwards and uses intake at the same time
          new ParallelCommandGroup(new DriveCommand(drive, -1.46,  1, 0, 0), new IntakeCommand(intake)),

          //drive forward again and then shoots the collected note
          new SequentialCommandGroup(new DriveCommand(drive, 1.46, 1, 0, 0), new ShooterCommand(shooter, conveyor)),

          //leaves starting zone
          new SequentialCommandGroup(new DriveCommand(drive, 2.9, 0, -1, 0), 
          new DriveCommand(drive, 1.5, -1, 0, 0))  //these two are a part of the same group i just set them on different lines for readability

        );
      }else{
        addCommands(

          //shoots preloaded note
          new ParallelCommandGroup(new ShooterCommand(shooter, conveyor)),

          //leaves starting zone
          new SequentialCommandGroup(new DriveCommand(drive, 2.9, 0, -1, 0), 
          new DriveCommand(drive, 1.5, -1, 0, 0))  //these two are a part of the same group i just set them on different lines for readability
        );
      }
    }
}
