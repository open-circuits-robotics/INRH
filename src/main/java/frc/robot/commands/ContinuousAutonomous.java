package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ContinuousAutonomous extends CommandBase {
    DriveTrainSubsystem driveTrainSubsystem;
    Timer timer;
    public ContinuousAutonomous(DriveTrainSubsystem dTrainSubsystem, Timer m_timer) {
        driveTrainSubsystem = dTrainSubsystem;
        timer = m_timer;
        addRequirements(driveTrainSubsystem);
    } 

    @Override
    public void initialize() {
        System.out.println("Starting continuous auto");
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        if (timer.get() < 4.65) {
            // spins
            driveTrainSubsystem.mecanumDrive.driveCartesian(0, 0, 1);
        }
    }

    @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (timer.get() >= 4.65);
  }
}
