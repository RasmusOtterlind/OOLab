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

   protected double getX() {return x;}
   protected double getY() {return y;}

   protected double getDirection() {
        return direction;
    }
    protected void setDirection(double direction) {
        this.direction = direction;
    }

    protected void setX(double x) {
        this.x = x;
    }
    protected void setY(double y) {
        this.y = y;
    }
}
