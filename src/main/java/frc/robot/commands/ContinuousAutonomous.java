package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.hardware.Limelight;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class ContinuousAutonomous extends Command {
    DriveTrainSubsystem driveTrainSubsystem;
    LimelightSubsystem limelightSubsystem;
    Timer timer;
    double targetX, targetY, targetZ;
    private int stage;
    private double prevTime;
    public ContinuousAutonomous(DriveTrainSubsystem dTrainSubsystem, Timer m_timer, LimelightSubsystem limelightSubsystem) {
        driveTrainSubsystem = dTrainSubsystem;
        this.limelightSubsystem = limelightSubsystem;
        timer = m_timer;
        addRequirements(driveTrainSubsystem, limelightSubsystem);
    } 

    @Override
    public void initialize() {
        System.out.println("Starting continuous auto");
        stage = 0;
        timer.reset();
        timer.start();
        prevTime = timer.get();
    }

    @Override
    public void execute() {
        double deltaT = Math.abs(timer.get()-prevTime);
        double velZ 
        switch (stage) {
            case 0:
                // Go Forward
                
                break;
            default:
                break;
        }
        prevTime = timer.get();
    }

    public void readLimelight(Limelight l){
        double[] defaultArray = {0,0,0,0,0,0};
        double[] poseArray = l.targetPose.getDoubleArray(defaultArray);
        targetX = poseArray[0];
        targetY = poseArray[1];
        targetZ = poseArray[2];
        System.out.println("pose from limelight " + l.name + ": x:" + targetX + " y:" + targetY + " z:" + targetZ);
    }

    @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (timer.get() >= 14);
  }
}
