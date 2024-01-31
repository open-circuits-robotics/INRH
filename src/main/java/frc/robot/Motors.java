package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Motors {
    public final static PWMSparkMax m_leftDrive = new PWMSparkMax(2);
    public final static PWMSparkMax m_leftDriveTwo = new PWMSparkMax(3);
    public final static PWMSparkMax m_rightDrive = new PWMSparkMax(0);
    public final static PWMSparkMax m_rightDriveTwo = new PWMSparkMax(1);

    public static void setMotors() {
        m_leftDrive.setInverted(true);
        
    }
}