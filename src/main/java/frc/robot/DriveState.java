package frc.robot;


import frc.robot.subsystems.ClimberSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class DriveState {
    public final double xSpeed;
    public final double ySpeed;
    public final double rotation;
    public final double intake;
    public final double shooter;
    public final double angle;
    public final double climb;
    public final double climberSpeedConstant = 0.5;
    public final double climbersSpeedConstant = 0.5;
    

    public DriveState(double xs, double ys, double rot, double in, double sh, double a, double climb) {
        xSpeed = xs;
        ySpeed = ys;
        rotation = rot;
        intake = in;
        shooter = sh;
        angle = a;
        this.climb = climb * climbersSpeedConstant;
    }

    public void sync(DriveTrainSubsystem driveTrainSubsystem, IntakeSubsystem intakeSubsystem, ClimberSubsystem climberSubsystem) {
        driveTrainSubsystem.differentialDrive.arcadeDrive(xSpeed, rotation);
        //System.out.println(xSpeed + " " + rotation);
        intakeSubsystem.intakeMotors.set(intake*0.7);
        intakeSubsystem.beltShooterMotor.set(shooter * 0.5);
        intakeSubsystem.wheelShooterMotor.set(Math.round(shooter+0.1) *1);
        intakeSubsystem.secondWheelShooterMotor.set(Math.round(shooter+0.1)*1);
        climberSubsystem.leftClimberMotor.set(climb);
        climberSubsystem.rightClimberMotor.set(climb * climberSpeedConstant);


    }
}