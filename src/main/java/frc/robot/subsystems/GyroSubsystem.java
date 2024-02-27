package frc.robot.subsystems;

import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class GyroSubsystem extends SubsystemBase {
    private ADIS16470_IMU gyro = new ADIS16470_IMU();
    private double lastReadingTime = 0;
    private double vels[] = {0, 0, 0};
    private double pos[] = {0, 0, 0};

    //FYI!!! X-axis is left-right, Y-axis is front-back, and Z-axis is up-down. Halie I told you so.
    public double[] getPos(double time) {
        double deltaT = time - lastReadingTime;
        vels[0] = vels[0] + gyro.getAccelX()*deltaT;
        vels[1] = vels[1] + gyro.getAccelY()*deltaT;
        vels[2] = vels[2] + gyro.getAccelZ()*deltaT;
        pos[0] = pos[0] + vels[0] * deltaT;
        pos[1] = pos[1] + vels[1] * deltaT;
        pos[2] = pos[2] + vels[2] * deltaT;
        lastReadingTime = time;
        return pos;
    }

    public void resetGyro(){
        //don't reset vels I don't think because if you do that it will probably get all messed up
        pos[0] = 0;
        pos[1] = 0;
        pos[2] = 0;

    }
}
