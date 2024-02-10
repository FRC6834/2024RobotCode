package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ConveyerSubsystem {
    private final CANSparkMax runMotor = new CANSparkMax(14, MotorType.kBrushless);



    public void startMotor(){
        runMotor.set(1);
    }

    public void stopMotor(){
        runMotor.set(0);
    }
}
