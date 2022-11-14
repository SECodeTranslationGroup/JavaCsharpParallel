namespace Parallel.Vector;

public struct Vector3
{
    private double _x;

    private double _y;

    private double _z;

    public double X
    {
        get => _x;
        set => _x = value;
    }

    public double Y
    {
        get => _y;
        set => _y = value;
    }

    public Vector3(double x, double y, double z)
    {
        _x = x;
        _y = y;
        _z = z;
    }

    public double Distance(Vector3 other)
    {
        double distX = other._x - _x;
        double distY = other._y - _y;
        double distZ = other._z - _z;
        return Math.Sqrt(distX * distX + distY * distY + distZ * distZ);
    }
}