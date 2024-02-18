package frc.robot.hardware;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    public final String name;
    public NetworkTable table;
    public NetworkTableEntry tx, ty, ta;
    public Limelight(String n){
        name = n;
        //System.out.println("Reading limelight "+name);
        update();
    }
    public void update(){
        table = NetworkTableInstance.getDefault().getTable(name);
        tx = table.getEntry("tx");
        ty = table.getEntry("ty");
        ta = table.getEntry("ta");
        
    }
}
