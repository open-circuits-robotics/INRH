package frc.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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

        sensitivity = (SmartDashboard.getNumber("DB/Slider 0", 5.0)+1) / 6;
        rotationSpeed = (SmartDashboard.getNumber("DB/Slider 1", 5.0)+1) / 6;
        SmartDashboard.putString("DB/String 0", "Slider 0 is speed sensitivity");
        SmartDashboard.putString("DB/String 1", "Slider 1 is turn sensitivity");
        

        switch (mode) {
            case 0:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(driveXboxController.getLeftY(), sensitivity), 
                    0, 
                    DriveMath.calculateTurnSpeed(driveXboxController.getRightX(), rotationSpeed),
                    0,
                    0,
                    0,
                    0
                );
                System.out.println("case 0");
                break;
            case 1:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(driveXboxController.getLeftY(), sensitivity),
                    DriveMath.calculateSpeed((driveXboxController.getLeftTriggerAxis()*-1+driveXboxController.getRightTriggerAxis()), sensitivity),
                    DriveMath.calculateTurnSpeed((driveXboxController.getRightX()*-1), rotationSpeed),
                    0,
                    0,
                    0,
                    0
                );
                
                System.out.println("case 1");
                break;
            //this one is for tank drive!
            //look at me doing stuff that makes sense with the stuff that's already there
            //or something
            case 2:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(driveXboxController.getLeftY(), sensitivity), 
                    0,
                    DriveMath.calculateTurnSpeed(driveXboxController.getRightX(), rotationSpeed),
                    peripheralXboxController.getLeftY(),
                    peripheralXboxController.getLeftTriggerAxis(),
                    0,
                    (peripheralXboxController.getRightBumper() ? 1 : 0) + (Math.round(peripheralXboxController.getRightTriggerAxis()) * -1)
                    );
                    
                //System.out.println("case 2");
                break;
            default:
                driveState = new DriveState(
                    DriveMath.calculateSpeed(driveXboxController.getLeftY(), 1-driveXboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateSpeed((driveXboxController.getLeftX() * -1), 1-driveXboxController.getLeftTriggerAxis()), 
                    DriveMath.calculateTurnSpeed(driveXboxController.getRightX()*-1, 0.82),
                    0,
                    0,
                    0,
                    0
                );
                
                System.out.println("default");
                break;
        }
        return driveState;
    }
}
