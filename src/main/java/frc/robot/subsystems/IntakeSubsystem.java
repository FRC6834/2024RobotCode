package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class IntakeSubsystem extends SubsystemBase {
 
    private final CANSparkMax kIntakeSystem = new CANSparkMax(DriveConstants.kIntakeSystem, MotorType.kBrushless);

    public void startMotor(){
        kIntakeSystem.set(0.5);
    }

    public void stopMotor(){
        kIntakeSystem.set(0);
    }
}
