public class Point3d extends Point2d {
    private double zCoord;

    public Point3d(double x, double y, double z) {
        super(x, y);
        this.zCoord = z;
    }

    public Point3d() {
        this(0, 0, 0);
    }

    public double getZ() {
        return zCoord;
    }

    public void setZ(double val) {
        zCoord = val;
    }

    public boolean equals(Point3d anotherPoint3d) {
        return super.getX() == anotherPoint3d.getX() && super.getY() == anotherPoint3d.getY()
                && this.zCoord == anotherPoint3d.getZ();
    }

    public double distanceTo(Point3d anotherPoint3d) {
        return Math.sqrt(
                Math.pow(super.getX() - anotherPoint3d.getX(), 2) + Math.pow(super.getY() - anotherPoint3d.getY(), 2)
                        + Math.pow(this.getZ() - anotherPoint3d.getZ(), 2));
    }
}
