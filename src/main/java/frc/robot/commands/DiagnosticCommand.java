package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Motors;
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
        Motors.m_leftDrive.set(1);
        try {
            timer.wait(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Motors.m_leftDrive.set(0);
        Motors.m_leftDriveTwo.set(1);
        try {
            timer.wait(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Motors.m_leftDriveTwo.set(0);
        Motors.m_rightDrive.set(1);
        try {
            timer.wait(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Motors.m_rightDrive.set(0);
        Motors.m_rightDriveTwo.set(1);
        try {
            timer.wait(1);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Motors.m_rightDriveTwo.set(0);

    }
}
