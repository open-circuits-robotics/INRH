package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Motors;


public class IntakeSubsystem extends SubsystemBase {
    public final PWMSparkMax intakeMotors;
    public IntakeSubsystem() {
        Motors.leftIntakeMotor.addFollower(Motors.rightIntakeMotor);
        intakeMotors = Motors.leftIntakeMotor;
    }
}
