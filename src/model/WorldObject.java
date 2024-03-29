package model;

/**
 * A superClass that makes objects trackable and placeable in the world
 */
 abstract class WorldObject {
    private double x;
    private double y;
    private double direction;

    /**
     * x and y coordinates aswell as a facing direction based on radian's
     * @param x
     * @param y
     * @param direction
     */

    public WorldObject(double x, double y, double direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public double getX() {return x;}
    public double getY() {return y;}

    public double getDirection() { return direction; }
    public void setDirection(double direction) { this.direction = direction;}

    protected void setX(double x) { this.x = x; }
    protected void setY(double y) { this.y = y; }
}
