// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.ContinuousAutonomous;
import frc.robot.commands.ContinuousDriveXbox;
import frc.robot.commands.TestMotor;
import frc.robot.commands.Spin;
import frc.robot.subsystems.ControlSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

public class RobotContainer {

  private final DriveTrainSubsystem driveTrainSubsystem;
  private final ControlSubsystem controlSubsystem;
  private final CommandXboxController xboxController;
  private final ContinuousDriveXbox continuousDriveXbox;
  private final ContinuousAutonomous continuousAutonomous;
  
  private final Timer m_timer;
  public static final ADIS16470_IMU imu = new ADIS16470_IMU();

  public RobotContainer() {
    xboxController = new CommandXboxController(0);
    m_timer = new Timer();
    Motors.setMotors();
    controlSubsystem = new ControlSubsystem(xboxController.getHID(), 1, 0.82, 0);
    driveTrainSubsystem = new DriveTrainSubsystem();
    
    continuousAutonomous = new ContinuousAutonomous(driveTrainSubsystem, m_timer);

    continuousDriveXbox = new ContinuousDriveXbox(driveTrainSubsystem, controlSubsystem);
    
    driveTrainSubsystem.setDefaultCommand(continuousDriveXbox);

    configureBindings();
    imu.calibrate();
  }

  private void configureBindings() {
    Trigger spinLTrigger = xboxController.x();
    spinLTrigger.whileTrue(new Spin(driveTrainSubsystem, imu));
    Trigger a = xboxController.a();
    a.onTrue(new TestMotor(Motors.m_leftDrive));
    Trigger b = xboxController.b();
    b.onTrue(new TestMotor(Motors.m_leftDriveTwo));
    Trigger x = xboxController.x();
    x.onTrue(new TestMotor(Motors.m_rightDrive));
    Trigger y = xboxController.y();
    y.onTrue(new TestMotor(Motors.m_rightDriveTwo));
  }

  public Command getAutonomousCommand() {
    return continuousAutonomous;
  }
}
