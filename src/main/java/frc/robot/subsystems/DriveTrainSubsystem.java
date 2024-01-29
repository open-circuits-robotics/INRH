package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.drive.MecanumDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motors;

public class DriveTrainSubsystem extends SubsystemBase {
    
    //public final MecanumDrive mecanumDrive;
    public final DifferentialDrive differentialDrive;

    public DriveTrainSubsystem() {

        //you may ask
        //why does this look different????
        //the answer is
        //wpilib 2024 :( 
        //apparently you don't have motorcontrollergroups anymore you just do followers
        Motors.m_leftDrive.addFollower(Motors.m_leftDriveTwo);
        Motors.m_rightDrive.addFollower(Motors.m_rightDriveTwo);
        differentialDrive = new DifferentialDrive(Motors.m_leftDrive, Motors.m_rightDrive);
        //this is mecanum stuff
            /*mecanumDrive = new MecanumDrive(
            Motors.m_leftDrive,
            Motors.m_leftDriveTwo,
            Motors.m_rightDrive,
            Motors.m_rightDriveTwo
            );*/

        
    }

}
