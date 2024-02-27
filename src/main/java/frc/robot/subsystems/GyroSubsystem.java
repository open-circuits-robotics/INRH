package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
    private static final double kVoltsPerDegreePerSecond = 0.0128;
    private ADIS16470_IMU gyro = new ADIS16470_IMU();
    private double lastReadingTime = 0;
    private double vels;
    private double posX = 0;
    private double posZ = 0;

    public double[] getVels(double time) {
        double deltaT = time - lastReadingTime;
    }

    public double getX(double time) {
        double deltaT = time - lastReadingTimeX;
        velX = velX + gyro.getAccelX()*deltaT;
        posX = posX + velX*deltaT;
        lastReadingTimeX = time;
        return posX;
    }
    public double getZ(double time) {
        double deltaT = time - lastReadingTimeZ;
        velZ = velZ + gyro.getAccelZ()*deltaT;
        posZ = posZ + velZ*deltaT;
        lastReadingTimeZ = time;
        return posZ;
    }
}
