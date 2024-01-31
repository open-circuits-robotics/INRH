package frc.robot;

import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveState {
    public final double xSpeed;
    public final double ySpeed;
    public final double rotation;

    public DriveState(double xs, double ys, double rot) {
        xSpeed = xs;
        ySpeed = ys;
        rotation = rot;
    }

    public void sync(DriveTrainSubsystem driveTrainSubsystem) {
        driveTrainSubsystem.differentialDrive.arcadeDrive(xSpeed, rotation);
        System.out.println(xSpeed + " " + rotation);
    }
}