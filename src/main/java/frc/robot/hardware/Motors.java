package frc.robot.hardware;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

public class Motors {
    //motors for new robot
    public final static PWMSparkMax leftDrive = new PWMSparkMax(2);
    public final static PWMSparkMax leftDriveTwo = new PWMSparkMax(3);
    public final static PWMSparkMax rightDrive = new PWMSparkMax(0);
    public final static PWMSparkMax rightDriveTwo = new PWMSparkMax(1);

    public final static PWMSparkMax leftIntakeMotor = new PWMSparkMax(4);
    public final static PWMSparkMax rightIntakeMotor = new PWMSparkMax(5);

    //motors for option 9
    /* 
    public final static PWMSparkMax m_leftDrive = new PWMSparkMax(1);
    public final static PWMSparkMax m_leftDriveTwo = new PWMSparkMax(0);
    public final static PWMSparkMax m_rightDrive = new PWMSparkMax(3);
    public final static PWMSparkMax m_rightDriveTwo = new PWMSparkMax(2);
    */


    public static void setMotors() {
        leftDrive.setInverted(true);
        
    }
}