package OOCar;

import java.awt.*;

/**
 * the abstract class vehicle with the basic characteristics of a car
 */
public abstract class Vehicle implements Movable{
     private int nrDoors; // Number of doors on the car
     private double enginePower; // Engine power of the car
     private double currentSpeed; // The current speed of the car
     private Color color; // Color of the car
     private String modelName; // The car model name
     private double x;
     private double y;
     private double direction;
     private double turnSpeed = 0.2;

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
     *
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

    Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnSpeed) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.turnSpeed = turnSpeed;
    }

}