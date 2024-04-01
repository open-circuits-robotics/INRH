package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Motors;


public class ClimberSubsystem extends SubsystemBase {
    public final Spark leftClimberMotor;
    public final Spark rightClimberMotor;
    // public final CANSparkMax shootingMotors;
    public ClimberSubsystem() {
        Motors.leftIntakeMotor.addFollower(Motors.rightIntakeMotor);
        leftClimberMotor = Motors.leftClimberMotor;
        rightClimberMotor = Motors.rightClimberMotor;
    }
}
