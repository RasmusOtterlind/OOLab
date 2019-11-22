package OOCar;

public class ServiceStation <T extends Vehicle> extends WorldObject {
    private Storage<T> storage = new Storage(10, Storage.UnloadOrder.selected, 2);

    public ServiceStation(double x, double y, double direction) {
        super(x, y, direction);
    }

    public void load(T vehicle){
        storage.addToStorage(vehicle, vehicle.getX(), vehicle.getY(), vehicle.getDirection());
    }
}
