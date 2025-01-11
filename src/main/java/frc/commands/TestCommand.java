package frc.commands;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveSubsystem;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class TestCommand extends Command{

  private final DriveSubsystem drive = new DriveSubsystem();
  
    public void align(){
      NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight"); //gets table of data dumped from the limelight
      double alignment = table.getEntry("tx").getDouble(0); //gets how far the april tag is from the middle of the screen
      int rotation = -5; //how much the bot rotates by
      final int bounding = 5; //margin of error for the bot
      //if apriltag is to the left of the bot make rotation positive 
      if(alignment<0){rotation = 5;}

      System.out.println("[INITIALIZED]: "+alignment);

      //turns until apriltag is from -5 to 5
      //its between -5 to 5 degrees in case the bot turns too fast or the limelight updates too slow to hit exactly 0 degrees
      while(alignment>=bounding&&alignment<=bounding*-1){
        new DriveCommand(drive, 0, 0, 0, rotation).withTimeout(1.5);

        System.out.println("[UPDATING ALIGNMENT]: "+alignment);

        //updates the alignment values
        //since networktableinstance.getdefault is only the valyes from the limelight when that line of code is executed you need to re-initialize it to get new data
        table = NetworkTableInstance.getDefault().getTable("limelight");
        alignment = table.getEntry("tx").getDouble(0); 
      }
    }
    //called when the command is initialized
    @Override
    public void initialize(){

    }

    //called every time the command is scheduled
    @Override
    public void execute(){

    }

    @Override
    public void end(boolean interrupted){

    }

    @Override
    public boolean isFinished(){
        return false;
    }
    
}
