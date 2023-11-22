package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.DriveMath;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ContinuousDriveXbox extends CommandBase {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private DriveTrainSubsystem driveTrainSubsystem;
    private XboxController xboxController;

    public ContinuousDriveXbox(DriveTrainSubsystem dTrainSubsystem, XboxController xController) {

        driveTrainSubsystem = dTrainSubsystem;
        xboxController = xController;

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        driveTrainSubsystem.mecanumDrive.driveCartesian(
            DriveMath.calculateSpeed(xboxController.getLeftY(), 1-xboxController.getLeftTriggerAxis()), 
            DriveMath.calculateSpeed((xboxController.getLeftX() * -1), 1-xboxController.getLeftTriggerAxis()), 
            DriveMath.calculateTurnSpeed(xboxController.getRightX()*-1, 0.82)
        );
    }
    

}