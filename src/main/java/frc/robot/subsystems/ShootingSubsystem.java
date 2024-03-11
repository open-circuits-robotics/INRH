package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Motors;
import com.revrobotics.CANSparkMax;


public class ShootingSubsystem extends SubsystemBase {
    public final CANSparkMax beltShooterMotor;
    public final CANSparkMax wheelShooterMotor;
    public final CANSparkMax secondWheelShooterMotor;
    // public final CANSparkMax shootingMotors;
    public ShootingSubsystem() {
        beltShooterMotor = Motors.beltShooterMotor;
        wheelShooterMotor = Motors.wheelShooterMotor;
        secondWheelShooterMotor = Motors.secondWheelShooterMotor;
    }
}
