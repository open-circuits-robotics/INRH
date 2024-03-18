package frc.robot;

public class PID {
    public double getPIDOutput(double setpoint, double position, double time, double lastSetpoint, double lastPosition, double lastTime, double integral, double integralClamp, double kP, double kI, double kD) {
		double error = setpoint - position;
		double lastError = lastSetpoint - lastPosition;
		double outputP = kP * error;
		integral = clamp(-integralClamp, integralClamp, integral + (error * (time - lastTime)));
		double outputI = kI * integral;
		double outputD = kD * ((error - lastError)/time - lastTime);
		double output = clamp(-1, 1, outputP + outputI + outputD);
		return output;
	}

    public double clamp(double min, double max, double value){
        if (value < min){
            return min;
        } else if (value > max){
            return max;
        } else {
            return value;
        }
    }
}
