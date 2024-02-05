package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Motors {
    //motors for new robot
    /*public final static PWMSparkMax m_leftDrive = new PWMSparkMax(2);
    public final static PWMSparkMax m_leftDriveTwo = new PWMSparkMax(3);
    public final static PWMSparkMax m_rightDrive = new PWMSparkMax(0);
    public final static PWMSparkMax m_rightDriveTwo = new PWMSparkMax(1);*/

    //motors for option 9
    public final static PWMSparkMax m_leftDrive = new PWMSparkMax(1);
    public final static PWMSparkMax m_leftDriveTwo = new PWMSparkMax(0);
    public final static PWMSparkMax m_rightDrive = new PWMSparkMax(3);
    public final static PWMSparkMax m_rightDriveTwo = new PWMSparkMax(2);


    public static void setMotors() {
        m_leftDrive.setInverted(true);
        
    }
}