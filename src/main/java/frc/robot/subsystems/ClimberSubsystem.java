package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SubsystemConstants;

public class ClimberSubsystem extends SubsystemBase {
    
    //Climber Variables
    private final CANSparkMax climberLeft = new CANSparkMax(SubsystemConstants.kLeftClimber, MotorType.kBrushless);
    private final CANSparkMax climberRight = new CANSparkMax(SubsystemConstants.kRightClimber, MotorType.kBrushless);

    //Left Climber goes Up
    public void climberLeftUp(){
        climberLeft.set(-.75);
    }
    //Left Climber goes Down
    public void climberLeftDown(){
        climberLeft.set(.75);
        /*if (climberLeft.getEncoder().getPosition() >= 5){
            climberLeft.stopMotor();
        }*/
    }

    //Right Climber goes Up
    public void climberRightUp(){
        climberRight.set(.75);
    }

    //Right Climber goes DOwn
    public void climberRightDown(){
        climberRight.set(-.75);
        /*if (climberRight.getEncoder().getPosition() <= -5){
            climberRight.stopMotor();
        }*/
    }

    //Right Climber no go
    public void stopRightMotor(){
        climberRight.set(0);
    }

    //Left climber no go
    public void stopLeftMotor(){
        climberLeft.set(0);
    }
    
    //Resets encoders to zero
    public void resetEncoder(){
        climberLeft.getEncoder().setPosition(0.0);
        climberRight.getEncoder().setPosition(0.0);
    }

}
