package OOCar;

/**
 * A subclass to WorldObject.
 * A class that can be specified to only receive vehicles of specific types.
 * @param <T>
 */
public class ServiceStation <T extends Vehicle> extends WorldObject {
    private Storage<T> storage = new Storage(10, Storage.UnloadOrder.selected, 2);

    public ServiceStation(double x, double y, double direction) {
        super(x, y, direction);
    }

    /**
     * Loads the specific vehicle of the right type of serviceStation.
     * @param vehicle the vehicle
     */
    public void load(T vehicle){
        storage.addToStorage(vehicle, vehicle.getX(), vehicle.getY(), vehicle.getDirection());
    }

    /**
     * Unloads the vehicle from the service station.
     * @param vehicle the vehicle
     */
    public void unloadStorage(T vehicle){
        storage.unloadStorage(getX(),getY(),getDirection(),vehicle);
    }
}
