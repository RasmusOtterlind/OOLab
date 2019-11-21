package OOCar;

import java.awt.*;

public class TransportTruck extends Vehicle implements IFlatbed, IStorage {
    private Flatbed flatbed = new Flatbed(100, 100, 0);
    private Storage<Vehicle> storage = new Storage<>(10, Storage.UnloadOrder.firstInFirstOut, 3.0);

    TransportTruck() {
        super(2, 200, 0, Color.magenta, "TransportTruck-2000", 0.05,10);
    }

    public void addToStorage(Vehicle vehicle){
        storage.addToStorage(vehicle);
    }

    public void moveStorage() {
        storage.moveStorage(getX(), getY(), getDirection());
    }

    public Vehicle removeFromStorage() {
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
