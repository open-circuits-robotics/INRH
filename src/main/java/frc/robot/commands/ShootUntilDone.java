package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IntakeSubsystem;

public class ShootUntilDone extends Command {
    private Timer timer;
    private double time;
    private IntakeSubsystem intakeSubsystem;
    public ShootUntilDone (IntakeSubsystem iSubsystem, double t) {
        time = t;
        intakeSubsystem = iSubsystem;
        timer = new Timer();
        addRequirements(intakeSubsystem);
    }
    @Override
    public void initialize() {
        timer.start();
    }
    @Override
    public void execute() {
        // Should be broken up into different commands for different stages.
        intakeSubsystem.intakeMotors.set(0.65);
        intakeSubsystem.beltShooterMotor.set(0.5);
        intakeSubsystem.wheelShooterMotor.set(1);
        intakeSubsystem.secondWheelShooterMotor.set(1);
    }
    public boolean isFinished() {
        return (timer.get() >= time); // Should be replaced with some sort of detection.
    }
}
