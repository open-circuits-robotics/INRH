 package frc.robot.commands;

import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;
import java.lang.Math;

public class Spin extends Command {
    public double starting_degrees;
    DriveTrainSubsystem driveTrainSubsystem;
    public ADIS16470_IMU gyro;
    public double angle;
    public double spin_by_degrees = 90;
    public Spin(DriveTrainSubsystem dTrainSubsystem, ADIS16470_IMU adis16470_IMU)
    {
        driveTrainSubsystem = dTrainSubsystem;
        gyro = adis16470_IMU;

        addRequirements(driveTrainSubsystem);
    }

    @Override
    public void initialize() {
        starting_degrees = gyro.getAngle();
        angle = 0;
        
    }



    @Override
    public void execute() {
        angle = Math.abs(starting_degrees - gyro.getAngle());
        System.out.print("Gyro: "+gyro.getAngle());
        System.out.print(", Start: "+starting_degrees);
        System.out.print(", Angle: "+angle);
        System.out.print(", Speed: "+90/(90-angle));
        System.out.print("\r");
        driveTrainSubsystem.differentialDrive.arcadeDrive(
            0,  
            spin_by_degrees/(spin_by_degrees-angle)
            );
    }

    @Override
    public boolean isFinished() {
        return (angle >= spin_by_degrees);

    }
}
