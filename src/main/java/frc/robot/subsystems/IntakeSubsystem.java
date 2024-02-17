package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DriveConstants;
import frc.robot.Constants.SubsystemConstants;

public class IntakeSubsystem extends SubsystemBase {
    //choose better variable name
    private final CANSparkMax kIntakeSystem = new CANSparkMax(SubsystemConstants.kIntakeSystem, MotorType.kBrushless);

    //change speed to 50% speed
    public void startMotor(){
        kIntakeSystem.set(0.5);
    }
    //stops intakes
    public void stopMotor(){
        kIntakeSystem.set(0);
    }
}
