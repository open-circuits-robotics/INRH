package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motors;

public class DriveTrainSubsystem extends SubsystemBase {
    
    public final MecanumDrive mecanumDrive;

    public DriveTrainSubsystem() {
        mecanumDrive = new MecanumDrive(
            Motors.m_leftDrive,
            Motors.m_leftDriveTwo,
            Motors.m_rightDrive,
            Motors.m_rightDriveTwo
            );
        
    }

    public void setDefaultCommand(Command command)
    {
        // Use this for setting up xbox command
        super.setDefaultCommand(command);
    }

    
    

}
