package frc.commands;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ConveyorSubsystem;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;


public class SimpleAuto extends SequentialCommandGroup{
  /*whether or not the robot will go for a second note or if it will just leave the starting area after shooting the preloaded note. 
  if going for a 2nd note causes problems set this to false*/
  final boolean SECOND_NOTE = true;
  final  boolean FIRST_NOTE = true; //if false robot will just go for leave points

  public SimpleAuto(DriveSubsystem drive, IntakeSubsystem intake, ConveyorSubsystem conveyor, ShooterSubsystem shooter){

    //!!UNTESTED!!
      if(SECOND_NOTE){
        addCommands(

          //shoots preloaded note
          new ParallelCommandGroup(new ShooterCommand(shooter, conveyor)),

          //collects second note; drives backwards and uses intake at the same time
          new ParallelCommandGroup(new DriveCommand(drive, -1.46,  1, 0, 0), new IntakeCommand(intake)),

          //drive forward again and then shoots the collected note
          new SequentialCommandGroup(new DriveCommand(drive, 1.46, 1, 0, 0), new ShooterCommand(shooter, conveyor)),

          //leaves starting zone
          new SequentialCommandGroup(new DriveCommand(drive, 2.9, 0, -1, 0), 
          new DriveCommand(drive, 1.5, -1, 0, 0))  
          //^^these two are a part of the same group i just set them on different lines for readability

        );
      }else{ //ROBOT IS ON RIGHT SIDE OF THE SPEAKER (from driver pov) AND WILL NOT GO AFTER 2ND NOTE
        addCommands(

          //shoots preloaded note
          new ParallelCommandGroup(new ShooterCommand(shooter, conveyor)),

          //leaves starting zone
          new SequentialCommandGroup(new DriveCommand(drive, 2.9, 0, -1, 0), 
          new DriveCommand(drive, 1.5, -1, 0, 0))  
          //^^these two are a part of the same group i just set them on different lines for readability
        );
      } 
    
      //WILL NOT SHOOT NOTES; WILL ONLY DRIVE FORWARD (intended for use to gain leave points)
    if(!FIRST_NOTE){
      new DriveCommand(drive, 1.5, 1, 0, 0);
    }
  }
}
