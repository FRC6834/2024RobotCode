package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
    //Remember to update ID  
    private final CANSparkMax runMotor = new CANSparkMax(13, MotorType.kBrushless);


    public void startMotor(){
        runMotor.set(1);
    }

    public void stopMotor(){
        runMotor.set(0);
    }


}
