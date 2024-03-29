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

    private double x,y,area; 
    public ContinuousLimelight(LimelightSubsystem lSubsystem){
        limelightSubsystem = lSubsystem;

        addRequirements(limelightSubsystem);
    }
    
    public void readLimelight(Limelight l) {
       // System.out.print(l.name+":");
            x    = l.tx.getDouble(0.0);
            y    = l.ty.getDouble(0.0);
            area = l.ta.getDouble(0.0);
           // System.out.print(x+",");
            //System.out.print(y+",");
            //System.out.println(area);
    }

    @Override
    public void execute() {

        limelightSubsystem.update();
        readLimelight(limelightSubsystem.lefty);
        readLimelight(limelightSubsystem.righty);
    
        
    }
}
