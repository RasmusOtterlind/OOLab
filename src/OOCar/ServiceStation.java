package OOCar;

public class ServiceStation <T extends Vehicle> {
    private Storage<T> storage = new Storage(10, Storage.UnloadOrder.selected, 2);

    public void load(T vehicle){
        storage.addToStorage(vehicle, vehicle.getX(), vehicle.getY(), vehicle.getDirection());
    }
}
