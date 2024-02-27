package frc.robot.commands;

/*import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;*/
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.hardware.Limelight;
import frc.robot.subsystems.LimelightSubsystem;
// Test

public class ContinuousLimelight extends Command{
    private final LimelightSubsystem limelightSubsystem;
    private double distanceFromTag;
    public ContinuousLimelight(LimelightSubsystem lSubsystem){
        limelightSubsystem = lSubsystem;

        addRequirements(limelightSubsystem);
    }
    
    
    public double getDistanceFromTag() {
        return distanceFromTag;
    }
    @Override
    public void execute() {

        limelightSubsystem.update();
        distanceFromTag = limelightSubsystem.getDistanceFromTag();
    
    }
}
