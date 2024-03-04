package frc.robot.commands;



import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrainSubsystem;

public class Autonomous extends SequentialCommandGroup {

    private DriveTrainSubsystem driveTrainSubsystem;

    public Autonomous(DriveTrainSubsystem dTrainSubsystem) {
        driveTrainSubsystem = dTrainSubsystem;
        addCommands(null);
    }
    
}
