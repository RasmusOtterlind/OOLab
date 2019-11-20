package OOCar;

import java.awt.*;

public class TransportTruck extends Vehicle implements IFlatbed, IStorage {
    private Flatbed flatbed = new Flatbed(100, 100, 0);
    private Storage storage = new Storage(10, Storage.UnloadOrder.firstInFirstOut);

    TransportTruck() {
        super(2, 200, 0, Color.magenta, "TransportTruck-2000", 0.05,10);
    }

    void moveStorage() {
        storage.moveStorage(getX(), getY(), getDirection());
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.003;
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
