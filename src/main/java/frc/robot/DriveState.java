package frc.robot;


import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootingSubsystem;

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

    public void sync(DriveTrainSubsystem driveTrainSubsystem, IntakeSubsystem intakeSubsystem, ShootingSubsystem shootingSubsystem) {
        driveTrainSubsystem.differentialDrive.arcadeDrive(xSpeed, rotation);
        //System.out.println(xSpeed + " " + rotation);
        intakeSubsystem.intakeMotors.set(intake*0.7);
        shootingSubsystem.beltShooterMotor.set(shooter * 0.5);
        shootingSubsystem.wheelShooterMotor.set(Math.round(shooter+0.1) *1);
        shootingSubsystem.secondWheelShooterMotor.set(Math.round(shooter+0.1)*1);
        System.out.println(Math.round(shooter + 0.1) * 1);
    }
}