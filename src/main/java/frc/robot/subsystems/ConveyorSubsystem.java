package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SubsystemConstants;

public class ConveyorSubsystem extends SubsystemBase {

    //Instead of directly passing in CAN ID, use variable created in Constants.java
    //Delete this comment when fixed - George
    private final CANSparkMax conveyorMotor = new CANSparkMax(SubsystemConstants.kConveyorBelt, MotorType.kBrushless);

    //Conveyer goes forward - 30% speed
    public void forwardMotor(){
        conveyorMotor.set(.3);
    }
    //Conveyer goes forward - half normal speed
    public void halfForwardMotor(){
        conveyorMotor.set(.15);
    }
    //Covneyer stops
    public void stopMotor(){
        conveyorMotor.set(0);
    }
    //Covneyer moves backwards - 30% speed
    public void backwardsMotor(){
        conveyorMotor.set(-.3);
    }
}

