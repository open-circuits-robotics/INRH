package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;

public class UltrasonicSubsystem extends SubsystemBase{
   public AnalogInput ultrasonicSensor = new AnalogInput(0);
   
   public double voltageScaleFactor = 5/RobotController.getVoltage5V();

   public double currentDistanceCentimeters = ultrasonicSensor.getValue() * voltageScaleFactor * 0.125;

   public double currentDistanceInches = ultrasonicSensor.getValue() * voltageScaleFactor * 0.0492;
}
