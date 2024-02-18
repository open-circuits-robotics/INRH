package frc.robot.hardware;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

public class Motors {
    //motors for new robot
    public final static PWMSparkMax leftDrive = new PWMSparkMax(1);
    public final static PWMSparkMax leftDriveTwo = new PWMSparkMax(0);
    public final static PWMSparkMax rightDrive = new PWMSparkMax(3);
    public final static PWMSparkMax rightDriveTwo = new PWMSparkMax(2);

    public final static PWMSparkMax leftIntakeMotor = new PWMSparkMax(4);
    public final static PWMSparkMax rightIntakeMotor = new PWMSparkMax(5);

    public final static CANSparkMax can1 = new CANSparkMax(1, MotorType.kBrushless);
    public final static CANSparkMax can2 = new CANSparkMax(2, MotorType.kBrushless);

    //motors for option 9
    /* 
    public final static PWMSparkMax m_leftDrive = new PWMSparkMax(1);
    public final static PWMSparkMax m_leftDriveTwo = new PWMSparkMax(0);
    public final static PWMSparkMax m_rightDrive = new PWMSparkMax(3);
    public final static PWMSparkMax m_rightDriveTwo = new PWMSparkMax(2);
    */


    public static void setMotors() {
        can1.setInverted(true);
        leftDrive.setInverted(true);

    }
}