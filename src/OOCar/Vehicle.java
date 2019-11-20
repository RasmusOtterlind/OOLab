package OOCar;

import java.awt.*;

/**
 * the abstract class vehicle with the basic characteristics of a car
 */
public abstract class Vehicle implements Movable{
    /**
     * Number of doors on the vehicle
     */
     private int nrDoors; // Number of doors on the car
    /**
     * This determines the max speed of the vehicle
     */
     private double enginePower; // Engine power of the car
    /**
     * The speed of the vehicle used when you move it
     */
     private double currentSpeed; // The current speed of the car
    /**
     * The color of the vehicle
     */
     private Color color; // Color of the car
    /**
     * the name of the vehicle
     */
     private String modelName; // The car model name
    /**
     * The x coordinate for the vehicle
     */
     private double x;
    /**
     * The x coordinate for the vehicle
     */
     private double y;
    /**
     * The direction the vehicle is facing used in trigonometrical ways with Sin & Cos
     */
    private double direction;
    /**
     * the speed that the vehicle turns with
     */
     private double turnSpeed = 0.2;

    /**
     * The Constructor takes all the parameters mentioned.
     * @param nrDoors
     * @param enginePower
     * @param currentSpeed
     * @param color
     * @param modelName
     * @param turnSpeed
     */
    Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnSpeed) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.turnSpeed = turnSpeed;
    }
    private void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }
    public double getEnginePower() { return enginePower; }
    public double getCurrentSpeed() { return currentSpeed; }
    public void setColor(Color clr){ color = clr; }
    public Color getColor(){ return color; }
    public double getX(){return x;}
    public double getY(){return y;}


    /**
     * Start's the engine with a bit of speed
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Moves the car
     */
    public void move(){
        x += getCurrentSpeed()* Math.cos(direction);
        y += getCurrentSpeed()* Math.sin(direction);
    }

    public double getDirection() {
        return direction;
    }

    /**
     * Sets the vehicles position to be the same as the storage it's inside.
     * @param x
     * @param y
     * @param direction
     */
    void followStorage(double x, double y, double direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    /**
     * changes the direction the vehicle is facing to the left
     */
    public void turnLeft(){ direction += turnSpeed; }

    /**
     * changes the direction the vehicle is facing to the right
     */
    public void turnRight(){
        direction -= turnSpeed;
    }

    /**
     * Increases the speed of the car
     * @param amount
     */
    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    /**
     * Decreases the speed of the car
     * @param amount
     */
    private void decrementSpeed(double amount){
        setCurrentSpeed( Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /**
     * An abstract method that requires double as return value used when increasing speed
     * @return
     */
    public abstract double speedFactor();

    /**
     * Set's speed to 0
     */
    void stopEngine(){ currentSpeed = 0; }

    /**
     * increases the speed of the car
     * @param amount
     */
    public void gas(double amount){
        if(amount>=0 && amount<=1){incrementSpeed(amount); }
    }

    /**
     * decreases the speed of the car
     * @param amount
     */
    public void brake(double amount){
        if(amount>=0 && amount<=1){
            decrementSpeed(amount);
        }
    }

}