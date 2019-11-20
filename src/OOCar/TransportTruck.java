package OOCar;

import java.awt.*;

public class TransportTruck extends Truck implements IFlatbed, IStorage {
    private Storage storage = new Storage(10, Storage.UnloadOrder.firstInFirstOut);

    TransportTruck() {
        super(2, 200, 0, Color.magenta, "TransportTruck-2000", 0.05, new Flatbed(1, 100, 0));
    }

    private void moveStorage() {
        storage.moveStorage(getX(), getY(), getDirection());
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.003;
    }

}
