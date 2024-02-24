package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SubsystemConstants;

public class ShooterSubsystem extends SubsystemBase {
    //Remember to update ID  
    private final CANSparkMax leftMotor = new CANSparkMax(SubsystemConstants.kLeftShooter, MotorType.kBrushless);
    private final CANSparkMax rightMotor = new CANSparkMax(SubsystemConstants.kRightShooter, MotorType.kBrushless);

    //Shooter goes - 100%
    //Right is reversed on purpose
    public void startMotor(){
        leftMotor.set(1);
        rightMotor.set(-1);
    }
    //Stops shooter
    public void stopMotor(){
        leftMotor.set(0);
        rightMotor.set(0);
    }
    //Shooter runs - 50%
    public void startMotorSlowSpeed(){
        leftMotor.set(.25);
        rightMotor.set(-.25);
    }
}
