package parallel.vector;

public class Vector3 {
    private double x;

    private double y;

    private double z;

    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double distance(Vector3 other)
    {
        double distX = other.x - x;
        double distY = other.y - y;
        double distZ = other.z - z;
        return Math.hypot(Math.hypot(distX, distY), distZ);
    }
}
