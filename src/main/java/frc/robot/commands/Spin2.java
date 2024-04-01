package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.GyroSubsystem;

public class Spin2 extends PIDCommand {
    public double setpoint;
    public DriveTrainSubsystem driveTrainSubsystem;
    public GyroSubsystem gyroSubsystem;
    public Spin2(double angle, DriveTrainSubsystem dTrainSubsystem, GyroSubsystem gSubsystem) {
        
        super(new PIDController(0.1, 0, 0.8), () -> gSubsystem.getAngle(), angle, z -> dTrainSubsystem.rotate(z), dTrainSubsystem, gSubsystem);
        
        setpoint = angle;
        driveTrainSubsystem = dTrainSubsystem;
        gyroSubsystem = gSubsystem;
    }

    @Override
    public boolean isFinished() {

        System.out.println("Current rot "+gyroSubsystem.getAngle());
        return (Math.round(setpoint) == Math.round(gyroSubsystem.getAngle()));
    }
}
