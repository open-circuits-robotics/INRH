package frc.robot;


import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

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

    public void sync(DriveTrainSubsystem driveTrainSubsystem, IntakeSubsystem intakeSubsystem) {
        driveTrainSubsystem.differentialDrive.arcadeDrive(xSpeed, rotation);
        //System.out.println(xSpeed + " " + rotation);
        intakeSubsystem.intakeMotors.set(intake*0.7);
        intakeSubsystem.beltShooterMotor.set(shooter * 0.5);
        if (shooter > 0.25) {
            intakeSubsystem.wheelShooterMotor.set(Math.round(shooter+0.1) *0.5);
            intakeSubsystem.secondWheelShooterMotor.set(Math.round(shooter+0.1)*0.5);
        } else {
            intakeSubsystem.wheelShooterMotor.set(Math.round(intake) *0.75);
            intakeSubsystem.secondWheelShooterMotor.set(Math.round(intake)*0.75);
        }
        System.out.println(Math.round(shooter + 0.1) * 1);
    }
}