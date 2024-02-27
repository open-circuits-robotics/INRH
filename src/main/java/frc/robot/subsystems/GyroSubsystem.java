package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
    private static final double kVoltsPerDegreePerSecond = 0.0128;
    private ADIS16470_IMU gyro = new ADIS16470_IMU();

    public double getX() {
        return gyro.getAccelX();
    }
    public double getZ() {
        return gyro.getAccelZ();
    }
}
