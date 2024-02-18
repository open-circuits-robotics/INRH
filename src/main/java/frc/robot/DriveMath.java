package frc.robot;

public class DriveMath {
    public static double calculateSpeed(double x, double sensitivity)
    {
        if (x > 0.5) {
            x = (x - 0.5) * 2;
        } else if (x < -0.5){
            x = (x + 0.5) * 2;
        } else {
            x = 0;
        }
        return x * Math.abs(x) * sensitivity;
    }

    public static double calculateTurnSpeed(double x, double sensitivity)
    {
        if (x > 0.5) {
            x = (x - 0.5) * 2;
        } else if (x < -0.5){
            x = (x + 0.5) * 2;
        } else {
            x = 0;
        }
        return x * Math.abs(x) * sensitivity;
    }   
}
