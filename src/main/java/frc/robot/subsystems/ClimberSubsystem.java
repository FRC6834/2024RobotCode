package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SubsystemConstants;

public class ClimberSubsystem extends SubsystemBase {

    //Instead of directly passing in CAN ID, use variable created in Constants.java
    //Need to create 2 climber objects
    //Delete this comment when fixed - George
    private final CANSparkMax climberLeft = new CANSparkMax(SubsystemConstants.kLeftClimber, MotorType.kBrushless);
    private final CANSparkMax climberRight = new CANSparkMax(SubsystemConstants.kRightClimber, MotorType.kBrushless);


    //Need ability to make climber go up and down
    //Let's name the methods climbUp and climbDown or something similar
    //Delete this comment when fixed - George
    public void climbUp(){
        climberLeft.set(1);
    }

    public void climbDown(){
        climberRight.set(1);
    }

    public void stopMotor(){
        climberRight.set(0);
        climberLeft.set(0);
    }    
}
