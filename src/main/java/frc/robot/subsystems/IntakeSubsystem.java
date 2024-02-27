package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.SubsystemConstants;

public class IntakeSubsystem extends SubsystemBase {

    private final CANSparkMax kIntakeSystem = new CANSparkMax(SubsystemConstants.kIntakeSystem, MotorType.kBrushless);

    //runs intake
    public void startMotor(){
        kIntakeSystem.set(-0.35);
    }

    //stops intake
    public void stopMotor(){
        kIntakeSystem.set(0);
    }
}
