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
import frc.robot.commands.ContinuousLimelight;
import frc.robot.commands.TestMotor;
import frc.robot.hardware.Motors;
import frc.robot.commands.Spin;
import frc.robot.subsystems.CameraSubsystem;
import frc.robot.subsystems.ControlSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class RobotContainer {

  private final DriveTrainSubsystem driveTrainSubsystem;
  private final ControlSubsystem controlSubsystem;
  private final IntakeSubsystem intakeSubsystem;
  private final LimelightSubsystem limelightSubsystem;
  private final CommandXboxController driveXboxController;
  private final CommandXboxController peripheralXboxController;
  private final ContinuousDriveXbox continuousDriveXbox;
  private final ContinuousAutonomous continuousAutonomous;
  private final ContinuousLimelight continuousLimelight;
  private final GyroSubsystem gyroSubsystem;
  private final CameraSubsystem cameraSubsystem;
  
  
  private final Timer m_timer;
  //public static final ADIS16470_IMU imu = new ADIS16470_IMU();

  public RobotContainer() {
    driveXboxController = new CommandXboxController(0);
    peripheralXboxController = new CommandXboxController(1);
    m_timer = new Timer();
    Motors.setMotors();
    controlSubsystem    = new ControlSubsystem(driveXboxController.getHID(), peripheralXboxController.getHID(), 1, 1.0, 2);
    driveTrainSubsystem = new DriveTrainSubsystem();
    limelightSubsystem = new LimelightSubsystem();
    gyroSubsystem = new GyroSubsystem();
    cameraSubsystem = new CameraSubsystem();
    intakeSubsystem = new IntakeSubsystem();

    
    continuousAutonomous = new ContinuousAutonomous(driveTrainSubsystem, m_timer, limelightSubsystem, gyroSubsystem, intakeSubsystem);
    continuousDriveXbox  = new ContinuousDriveXbox(driveTrainSubsystem, controlSubsystem, intakeSubsystem);
    continuousLimelight  = new ContinuousLimelight(limelightSubsystem);
    
    driveTrainSubsystem.setDefaultCommand(continuousDriveXbox);
    limelightSubsystem.setDefaultCommand(continuousLimelight);

    configureBindings();
    //imu.calibrate();
  }

  private void configureBindings() {
    //Trigger spinLTrigger = driveXboxController.x();
    //spinLTrigger.whileTrue(new Spin(driveTrainSubsystem, imu));
    Trigger a = driveXboxController.a();
    a.onTrue(new TestMotor(Motors.leftDrive));
    Trigger b = driveXboxController.b();
    b.onTrue(new TestMotor(Motors.leftDriveTwo));
    Trigger x = driveXboxController.x();
    x.onTrue(new TestMotor(Motors.rightDrive));
    Trigger y = driveXboxController.y();
    y.onTrue(new TestMotor(Motors.rightDriveTwo));
  }

  public Command getAutonomousCommand() {
    return continuousAutonomous;
  }
}
