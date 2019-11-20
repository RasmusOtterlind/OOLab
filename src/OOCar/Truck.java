package OOCar;

import java.awt.*;

public abstract class Truck extends Vehicle {

    private Storage storage;

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
    Truck(int nrDoors, double enginePower, double currentSpeed, Color color, String modelName, double turnSpeed, Storage storage) {
        super(nrDoors, enginePower, currentSpeed, color, modelName, turnSpeed);
        this.storage = storage;
    }

    private void moveStorage() {
        storage.moveStorage(getX(), getY(), getDirection());
    }
}
