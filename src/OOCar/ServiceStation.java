package OOCar;

public class ServiceStation <T extends Vehicle> {
    private double x;
    private Storage<T> storage = new Storage(10, Storage.UnloadOrder.selected);



    
}
