package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.DriveState;
import frc.robot.subsystems.ControlSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ContinuousDriveXbox extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrainSubsystem driveTrainSubsystem;
    private final ControlSubsystem controlSubsystem;

    private DriveState currentState;

    public ContinuousDriveXbox(DriveTrainSubsystem dTrainSubsystem, ControlSubsystem cSubsystem) {

        driveTrainSubsystem = dTrainSubsystem;
        controlSubsystem = cSubsystem;

        addRequirements(driveTrainSubsystem);

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        currentState = controlSubsystem.getRoughDriveState();
        currentState.sync(driveTrainSubsystem);
    }
    

}