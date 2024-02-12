package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase {

    //Instead of directly passing in CAN ID, use variable created in Constants.java
    //Need to create 2 climber objects
    //Delete this comment when fixed - George
    private final CANSparkMax runMotor = new CANSparkMax(15, MotorType.kBrushless);
    private final CANSparkMax reverseMotor = new CANSparkMax(15, MotorType.kBrushless);


    //Need ability to make climber go up and down
    //Let's name the methods climbUp and climbDown or something similar
    //Delete this comment when fixed - George
    public void climbUp(){
        runMotor.set(1);
    }

    public void climbDown(){
        runMotor.set(1);
    }

    public void stopMotor(){
        runMotor.set(0);
    }    
}
