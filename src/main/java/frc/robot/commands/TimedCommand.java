package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

public class TimedCommand extends Command{
    private double time;
    protected Timer timer;
    public TimedCommand(double t) {
        timer = new Timer();
        time = t;
    }

    public void initialize() {
        timer.start();
    }

    public boolean isFinished() {
        return timer.get() >= time;
    }
}
