package frc.robot.commands;

import frc.robot.subsystems.IntakeSubsystem;

public class Shoot extends TimedCommand{
    private IntakeSubsystem intakeSubsystem;
    public Shoot(IntakeSubsystem iSubsystem) {
        super(1);
        intakeSubsystem = iSubsystem;
    }
    @Override
    public void execute() {
        intakeSubsystem.intakeMotors.set(0.5);
        intakeSubsystem.beltShooterMotor.set(0.7);
        intakeSubsystem.wheelShooterMotor.set(1);
        intakeSubsystem.secondWheelShooterMotor.set(1);
    }
}
