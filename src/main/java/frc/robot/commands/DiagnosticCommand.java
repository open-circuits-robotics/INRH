package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.hardware.Motors;
import frc.robot.subsystems.DriveTrainSubsystem;

public class DiagnosticCommand extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final DriveTrainSubsystem driveTrainSubsystem;
    private final Timer timer;
    
    public DiagnosticCommand(DriveTrainSubsystem dTrainSubsystem, Timer t) {

        driveTrainSubsystem = dTrainSubsystem;
        timer = t;
        addRequirements(driveTrainSubsystem);

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        Motors.leftDrive.set(1);
        try {
            timer.wait(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Motors.leftDrive.set(0);
        Motors.leftDriveTwo.set(1);
        try {
            timer.wait(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Motors.leftDriveTwo.set(0);
        Motors.rightDrive.set(1);
        try {
            timer.wait(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Motors.rightDrive.set(0);
        Motors.rightDriveTwo.set(1);
        try {
            timer.wait(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Motors.rightDriveTwo.set(0);

    }
}
