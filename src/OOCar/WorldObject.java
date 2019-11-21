package OOCar;

public class WorldObject {
    private double x;
    private double y;
    private double direction;

    public WorldObject(double x, double y, double direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    double getX() {return x;}
    double getY() {return y;}

    public double getDirection() {
        return direction;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setDirection(double direction) {
        this.direction = direction;
    }
}
