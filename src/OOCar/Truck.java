package OOCar;

import java.awt.*;

public abstract class Truck extends Vehicle {

    private Flatbed flatbed;

    /**
     * The Constructor takes all the parameters mentioned.
     *
     * @param nrDoors
     * @param enginePower
     * @param currentSpeed
     * @param color
     * @param modelName
     * @param turnSpeed
     */
    Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnSpeed, Flatbed flatbed) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, turnSpeed);
        this.flatbed = flatbed;
    }

    public void raiseFlatBed() {
        flatbed.raiseFlatBed(getCurrentSpeed());
    }

    public void lowerFlatBed() {
        flatbed.lowerFlatBed(getCurrentSpeed());
    }

    public boolean isMax() {return flatbed.isMax();}

    public boolean isLowest() {return flatbed.isLowest();}
}
