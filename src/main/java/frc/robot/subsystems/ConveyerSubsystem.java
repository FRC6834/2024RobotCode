package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyerSubsystem extends SubsystemBase {

    //Instead of directly passing in CAN ID, use variable created in Constants.java
    //Delete this comment when fixed - George
    private final CANSparkMax runMotor = new CANSparkMax(14, MotorType.kBrushless);

    //We want to have the ability to move the game piece forward and backward when it is inside of the conveyor
    //Both of these methods should run the conveyor at roughly 30% speed
    //There should be an additional method that runs the conveyor forward at 90% speed
    //Choose method names that clearly distinguish which method is which
    //Delete this comment when fixed
    public void startMotor(){
        runMotor.set(1);
    }

    public void stopMotor(){
        runMotor.set(0);
    }
}
