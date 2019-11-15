package OOCar;

import java.awt.*;

public class TransportTruck extends Vehicle{

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
    TransportTruck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnSpeed) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, turnSpeed);
    }

    @Override
    public double speedFactor() {
        return 0;
    }
}
