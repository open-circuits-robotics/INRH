// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.ContinuousAutonomous;
import frc.robot.commands.ContinuousDriveXbox;
import frc.robot.subsystems.DriveTrainSubsystem;

public class RobotContainer {

  private final DriveTrainSubsystem driveTrainSubsystem;
  private final XboxController xboxController;
  private final ContinuousDriveXbox continuousDriveXbox;
  private final ContinuousAutonomous continuousAutonomous;
  private final Timer m_timer;

  public RobotContainer() {
    Motors.setMotors();
    driveTrainSubsystem = new DriveTrainSubsystem();
    xboxController = new XboxController(0);
    m_timer = new Timer();

    continuousAutonomous = new ContinuousAutonomous(driveTrainSubsystem, m_timer);

    continuousDriveXbox = new ContinuousDriveXbox(driveTrainSubsystem, xboxController);
    
    driveTrainSubsystem.setDefaultCommand(continuousDriveXbox);

    configureBindings();
  }

  private void configureBindings() {}

  public Command getAutonomousCommand() {
    return continuousAutonomous;
  }
}
