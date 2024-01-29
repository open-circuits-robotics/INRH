package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class CameraSubsystem extends SubsystemBase{
    public final UsbCamera usbCamera0;
    public final UsbCamera usbCamera1;
    NetworkTableEntry cameraServer;

    public CameraSubsystem(){
        usbCamera0 = CameraServer.startAutomaticCapture(0);
        usbCamera1 = CameraServer.startAutomaticCapture(1);

        cameraServer = NetworkTableInstance.getDefault().getTable("").getEntry("CameraSelection");
    }
}
