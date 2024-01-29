package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.Command;

public class TestMotor extends Command {
    @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
    private final PWMSparkMax motorToBeTested;
    private final Timer timer;
    
    public TestMotor(PWMSparkMax motor) {
        motorToBeTested = motor;
        
        timer = new Timer();
        

    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        System.out.println("Testing Motor : "+motorToBeTested.getChannel()+", "+motorToBeTested.getPwmHandle());
        timer.start();
        
        while (timer.get() <= 2) {
            motorToBeTested.set(timer.get()-1);
            System.out.println("isAlive : "+motorToBeTested.isAlive());
            System.out.println("last command : "+motorToBeTested.get());
            System.out.println("isInverted : "+motorToBeTested.getInverted());
            System.out.println("isSafetyEnable : "+motorToBeTested.isSafetyEnabled());
        }

    }
}
