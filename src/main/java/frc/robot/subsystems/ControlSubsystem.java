package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.DriveMath;
import frc.robot.DriveState;

public class ControlSubsystem extends SubsystemBase {
    public final XboxController driveXboxController;
    public final XboxController peripheralXboxController;
    public double sensitivity;
    public double rotationSpeed;
    public final int mode;
    
    public ControlSubsystem(XboxController dXboxController, XboxController perXboxController) {
        this(dXboxController, perXboxController, 1.0, 1.0, 2);
    }
    
    public ControlSubsystem(XboxController dXboxController, XboxController perXboxController, double sen, double rotSpeed, int m) {
        driveXboxController = dXboxController;
        peripheralXboxController = perXboxController;
        sensitivity = sen;
        rotationSpeed = rotSpeed;
        mode = m;
    }
    public DriveState getRoughDriveState() {
        DriveState driveState;

        switch (mode) {
            case 0:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(driveXboxController.getLeftY(), 1-driveXboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateSpeed((driveXboxController.getLeftX() * -1), 1-driveXboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateTurnSpeed(driveXboxController.getRightX()*-1, 0.82),
                    0,
                    0,
                    0
                );
            case 1:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(driveXboxController.getLeftY(), sensitivity),
                    DriveMath.calculateSpeed((driveXboxController.getLeftTriggerAxis()*-1+driveXboxController.getRightTriggerAxis()), sensitivity),
                    DriveMath.calculateTurnSpeed((driveXboxController.getRightX()*-1), rotationSpeed),
                    0,
                    0,
                    0
                );
            //this one is for tank drive!
            //look at me doing stuff that makes sense with the stuff that's already there
            //or something
            case 2:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(driveXboxController.getLeftY(), sensitivity), 
                    0,
                    DriveMath.calculateTurnSpeed(driveXboxController.getRightX(), rotationSpeed),
                    peripheralXboxController.getLeftY(),
                    peripheralXboxController.getRightY(),
                    0
                    );
            default:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(driveXboxController.getLeftY(), 1-driveXboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateSpeed((driveXboxController.getLeftX() * -1), 1-driveXboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateTurnSpeed(driveXboxController.getRightX()*-1, 0.82),
                    0,
                    0,
                    0
                );
        }
        return driveState;
    }
}
