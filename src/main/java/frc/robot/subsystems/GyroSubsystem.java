package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Vector3;

public class GyroSubsystem extends SubsystemBase{
    private ADIS16470_IMU gyro;
    private Timer timer;
    private Vector3 accel;
    private Vector3 vel;
    private Vector3 pos;
    private double prevTime;
    public GyroSubsystem(ADIS16470_IMU g) {
        gyro = g;
        timer = new Timer();
    }

    public void resetCenter() {
        accel = new Vector3(0, 0, 0);
        vel = new Vector3(0, 0, 0);
        pos = new Vector3(0, 0, 0);
        timer.start();
        prevTime = 0;
    }

    @Override
    public void periodic() {
        double time_elapsed = (timer.get()-prevTime);
        accel.set(gyro.getAccelX(), gyro.getAccelY(), gyro.getAccelZ());
        vel.addVector(accel.multiply(time_elapsed));
        pos.addVector(vel.multiply(time_elapsed));
    }

    public double getAngle() {
        return (360+(gyro.getAngle()%360))%360;
    }

    public double getX() {
        return pos.x;
    }

    public double getY() {
        return pos.y;
    }

    public double getZ() {
        return pos.z;
    }
}
