package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DriveMath;
import frc.robot.DriveState;

public class ControlSubsystem extends SubsystemBase {
    public final XboxController xboxController;
    public double sensitivity;
    public double rotationSpeed;
    public final int mode;
    
    public ControlSubsystem(XboxController xController) {
        this(xController, 1.0, 0.82, 1);
    }
    
    public ControlSubsystem(XboxController xController, double sen, double rotSpeed, int m) {
        xboxController = xController;
        sensitivity = sen;
        rotationSpeed = rotSpeed;
        mode = m;
    }
    public DriveState getRoughDriveState() {
        DriveState driveState;

        switch (mode) {
            case 0:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(xboxController.getLeftY(), 1-xboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateSpeed((xboxController.getLeftX() * -1), 1-xboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateTurnSpeed(xboxController.getRightX()*-1, 0.82)
                );
            case 1:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(xboxController.getLeftY(), sensitivity),
                    DriveMath.calculateSpeed((xboxController.getLeftTriggerAxis()*-1+xboxController.getRightTriggerAxis()), sensitivity),
                    DriveMath.calculateTurnSpeed((xboxController.getRightX()*-1), rotationSpeed)
                );
            //this one is for tank drive!
            //look at me doing stuff that makes sense with the stuff that's already there
            //or something
            case 2:
                driveState = new DriveState(xboxController.getLeftY() * Math.abs(xboxController.getLeftY()), 
                0,
                xboxController.getRightX() * Math.abs(xboxController.getRightX()));
            default:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(xboxController.getLeftY(), 1-xboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateSpeed((xboxController.getLeftX() * -1), 1-xboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateTurnSpeed(xboxController.getRightX()*-1, 0.82)
                );
        }
        return driveState;
    }
}
