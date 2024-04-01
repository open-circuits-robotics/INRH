package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class Forward extends PIDCommand{
    private DriveTrainSubsystem driveTrainSubsystem;
    private GyroSubsystem gyroSubsystem;
    private double setpoint;
    public Forward(double meters, DriveTrainSubsystem dTrainSubsystem, GyroSubsystem gSubsystem) {
        super(new PIDController(0.0005, 0, 0.85), () -> gSubsystem.getX(), meters, x -> dTrainSubsystem.forward(x), dTrainSubsystem, gSubsystem);
        driveTrainSubsystem = dTrainSubsystem;
        gyroSubsystem = gSubsystem;
        setpoint = meters;
    }

    @Override
    public boolean isFinished() {
        return Math.round(gyroSubsystem.getX()*100)/100 == Math.round(setpoint*100)/100;
    }
}
