package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Limelight;
/*import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;*/

public class LimelightSubsystem extends SubsystemBase{
    public Limelight lefty;
    public Limelight righty;
    public LimelightSubsystem() {
        lefty = new Limelight("limelight-lefty");
        righty = new Limelight("limelight-righty");
    }

    public void update(){
        lefty.update();
        righty.update();
    }

}
