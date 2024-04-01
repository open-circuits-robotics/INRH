package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.drive.MecanumDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.hardware.Motors;

public class DriveTrainSubsystem extends SubsystemBase {
    
    //public final MecanumDrive mecanumDrive;
    public final DifferentialDrive differentialDrive;

    public DriveTrainSubsystem() {

        //you may ask
        //why does this look different????
        //the answer is
        //wpilib 2024 :( 
        //apparently you don't have motorcontrollergroups anymore you just do followers
        Motors.leftDrive.addFollower(Motors.leftDriveTwo);
  
        Motors.rightDrive.addFollower(Motors.rightDriveTwo);
        differentialDrive = new DifferentialDrive(Motors.leftDrive, Motors.rightDrive);
        //this is mecanum stuff
            /*mecanumDrive = new MecanumDrive(
            Motors.m_leftDrive,
            Motors.m_leftDriveTwo,
            Motors.m_rightDrive,
            Motors.m_rightDriveTwo
            );*/

        
    }

    public void forward(double x) {
        differentialDrive.arcadeDrive(x/5, 0);
    }

    public void rotate(double z) {
        System.out.println("Rotating "+z);
        differentialDrive.arcadeDrive(0, Math.min(Math.max(z, -0.75), 0.75));
    }

}
