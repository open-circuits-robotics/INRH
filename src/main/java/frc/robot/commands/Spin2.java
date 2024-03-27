package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDCommand;

public class Spin2 extends PIDCommand {
    public Spin2() {
        super(new PIDController(0, 0, 0), m_measurement, 0, m_useOutput, null)
    }
}
