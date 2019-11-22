package OOCar;

import java.awt.*;

/**
 * An abstract vehicle with the basic characteristics of a car.
 */
public abstract class Vehicle extends WorldObject implements Movable{

     private int nrDoors;
     private double enginePower;
     private double currentSpeed;
     private Color color;
     private String modelName;
     private double turnSpeed;
     private double size;
     private boolean isLoadedOn = false;
     private boolean engineRunning = false;
    /**
     * The Constructor takes all the parameters mentioned.
     * @param nrDoors Number of doors on the vehicle.
     * @param enginePower This determines the max speed of the vehicle.
     * @param currentSpeed The speed of the vehicle used when you move it.
     * @param color The color of the vehicle.
     * @param modelName The name of the vehicle.
     * @param turnSpeed How fast the vehicle turns.
     * @param size The "Size" of the vehicle.
     */
    Vehicle(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnSpeed, double size) {
        super(0, 0, 0);
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.turnSpeed = turnSpeed;
        this.size = size;
    }
    private void setCurrentSpeed(double currentSpeed) {this.currentSpeed = currentSpeed;}
    double getEnginePower() {return enginePower;}
    double getCurrentSpeed() {return currentSpeed;}
    void setColor(Color clr) {color = clr;}
    Color getColor() {return color;}
    double getSize() {return size;}
    boolean getEngineRunning(){ return engineRunning;}
    boolean getIsLoadedOn(){return isLoadedOn;}
    //private void setLoadedOn(){isLoadedOn = !isLoadedOn;}


    /**
     * Moves the vehicle based on it's current speed and direction.
     */
    public void move(){

        setX(getX() + getCurrentSpeed()* Math.cos(getDirection()));
        setY(getY() + getCurrentSpeed()* Math.sin(getDirection()));
    }

    /**
     * Sets the vehicles position to be the same as the storage it's inside.
     * @param x
     * @param y
     * @param direction
     */
    void updatePosition(double x, double y, double direction) {
        setX(x);
        setY(y);
        setDirection(direction);
    }

    /**
     * Changes the direction the vehicle is facing leftwards.
     */
    public void turnLeft() { setDirection(getDirection() + turnSpeed); }

    /**
     * Changes the direction the vehicle is facing rightwards.
     */
    public void turnRight(){
        setDirection( getDirection() - turnSpeed);
    }

    /**
     * Increases the speed of the car.
     * @param amount
     */
    private void incrementSpeed(double amount){
        setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount,getEnginePower()));
    }

    /**
     * Decreases the speed of the car.
     * @param amount
     */
    private void decrementSpeed(double amount){
        setCurrentSpeed( Math.max(getCurrentSpeed() - speedFactor() * amount,0));
    }

    /**
     * An abstract method that requires double as return value used when increasing speed.
     * @return
     */
    public abstract double speedFactor();

    /**
     * Start's the engine with a bit of speed if it's not loaded on another object.
     */
    public void startEngine(){
        if(!isLoadedOn && !engineRunning) {
            engineRunning = true;
            gas(0.1);
        }
    }

    /**
     * Turns of the vehicle if it's speed is 0.
     */
    public void stopEngine(){
        if (currentSpeed == 0){
            engineRunning = false;
        }
    }

    /**
     * Increases the speed of the car if the engine is running.
     * @param amount
     */
    public void gas(double amount){
        if(engineRunning && amount>=0 && amount<=1){
            incrementSpeed(amount);
        }
    }

    /**
     * Lowers the speed of the car.
     * @param amount
     */
    public void brake(double amount){
        if(amount>=0 && amount<=1){
            decrementSpeed(amount);
        }
    }

}