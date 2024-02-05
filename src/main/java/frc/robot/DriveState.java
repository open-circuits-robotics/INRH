package frc.robot;

import frc.robot.subsystems.DriveTrainSubsystem;

public class DriveState {
    public final double xSpeed;
    public final double ySpeed;
    public final double rotation;
    public final double intake;
    public final double shooter;
    public final double angle;

    public DriveState(double xs, double ys, double rot, double in, double sh, double a) {
        xSpeed = xs;
        ySpeed = ys;
        rotation = rot;
        intake = in;
        shooter = sh;
        angle = a;
    }

    public void sync(DriveTrainSubsystem driveTrainSubsystem) {
        driveTrainSubsystem.differentialDrive.arcadeDrive(xSpeed, rotation);
        System.out.println(xSpeed + " " + rotation);
    }
}