package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShootingSubsystem;

public class ShootUntilDone extends Command {
    private Timer timer;
    private double time;
    private IntakeSubsystem intakeSubsystem;
    private ShootingSubsystem shootingSubsystem;
    public ShootUntilDone (IntakeSubsystem iSubsystem, double t, ShootingSubsystem shootingSubsystem) {
        time = t;
        intakeSubsystem = iSubsystem;
        this.shootingSubsystem = shootingSubsystem;
        timer = new Timer();
        addRequirements(intakeSubsystem, shootingSubsystem);
    }
    @Override
    public void initialize() {
        timer.start();
    }
    @Override
    public void execute() {
        // Should be broken up into different commands for different stages.
        intakeSubsystem.intakeMotors.set(0.65);
        shootingSubsystem.beltShooterMotor.set(0.5);
        shootingSubsystem.wheelShooterMotor.set(1);
        shootingSubsystem.secondWheelShooterMotor.set(1);
    }
    public boolean isFinished() {
        return (timer.get() >= time); // Should be replaced with some sort of detection.
    }
}
