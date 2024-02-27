package frc.robot.hardware;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class Limelight {
    public final String name;
    public NetworkTable table;
    private NetworkTableEntry tx, ty, ta, targetPose;
    private double[] defaultArray = {0, 0, 0, 0, 0, 0};
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
        targetPose = table.getEntry("targetpose_robotspace");
    }
    public double[] readTargetPos() {
        return targetPose.getDoubleArray(defaultArray);
    }
}
