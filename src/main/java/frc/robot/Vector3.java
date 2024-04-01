package frc.robot;

public class Vector3 {
    public double x;
    public double y;
    public double z; // Up
    public Vector3(double _x, double _y, double _z) {
        x = _x;
        y = _y;
        z = _z;
    }
    public void set(double _x, double _y, double _z) {
        x = _x;
        y = _y;
        z = _z;
    }
    public void addVector(Vector3 v) {
        x = x + v.x;
        y = y + v.y;
        z = z + v.z;
    }
    public Vector3 multiply(double d) {
        Vector3 v3 = new Vector3(x * d, y * d, z * d);
        return v3;
    }
}
