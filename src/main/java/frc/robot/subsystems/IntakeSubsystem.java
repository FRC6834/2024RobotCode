package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;

public class IntakeSubsystem extends SubsystemBase {
    //choose better variable name
    private final CANSparkMax runMotor = new CANSparkMax(DriveConstants.kIntakeSystem, MotorType.kBrushless);

    //change speed to 50% speed
    public void startMotor(){
        runMotor.set(1);
    }

    public void stopMotor(){
        runMotor.set(0);
    }
}
