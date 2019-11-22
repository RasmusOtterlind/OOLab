package OOCar;

import java.awt.*;

/**
 * A subclass to Vehicle. Implements interface IStorage.
 */
public class TransportTruck extends Vehicle implements IStorage {
    /**
     *  Composition: Creating new object flatbed to reach method in the class Flatbed with the help of delegation.
     */
    private Flatbed flatbed = new Flatbed(100, 100, 0);
    /**
     *  Composition: Creating new object storage to reach method in the class Storage with the help of delegation.
     */
    private Storage<Vehicle> storage = new Storage<>(10, Storage.UnloadOrder.firstInFirstOut, 3.0);

    TransportTruck() {
        super(2, 200, 0, Color.magenta, "TransportTruck-2000", 0.05,10);
    }

    /**
     * Add vehicle to the storage
     * @param vehicle The vehicle you want to load.
     */
    public void addToStorage(Vehicle vehicle){
        if (isLowest() && vehicle.getIsLoadedOn()){
            storage.addToStorage(vehicle, getX(), getY(), getDirection());
        }
    }

    public void moveStorage() {
        storage.moveStorage(getX(), getY(), getDirection());
    }

    public Vehicle unloadStorage() {
        return null;
    }

    @Override
    public void move(){
        super.move();
        moveStorage();
    }

    @Override
    public double speedFactor() {
        if(isMax()){
        return getEnginePower() * 0.03;
        }
        return 0;
    }

    public void raiseFlatBed() { flatbed.raiseFlatBed(getCurrentSpeed()); }

    public void lowerFlatBed() {
        flatbed.lowerFlatBed(getCurrentSpeed());
    }

    public boolean isMax() {return flatbed.isMax();}

    public boolean isLowest() {return flatbed.isLowest();}
}
