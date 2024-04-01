package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.GyroSubsystem;
import frc.robot.subsystems.IntakeSubsystem;

public class ComplexAuto extends SequentialCommandGroup{
    public ComplexAuto(DriveTrainSubsystem dTrainSubsystem, IntakeSubsystem iSubsystem, GyroSubsystem gSubsystem) {
        addCommands(
            new Spin2(90, dTrainSubsystem, gSubsystem)
        );
    }
}
