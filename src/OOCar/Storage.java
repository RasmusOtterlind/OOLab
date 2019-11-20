package OOCar;

import java.util.ArrayList;
import java.util.List;

class Storage {

    enum UnloadOrder {
        firstInFirstOut, lastInFirstOut, selected;
    }
    private double maxSpace;
    private double largestLoadingSize = 3.0;
    private double currentFillAmount = 0;
    private UnloadOrder unloadOrder;
    private List<Vehicle> currentStorage = new ArrayList<>();

    Storage(int maxSpace, UnloadOrder unloadOrder) {
        this.maxSpace = maxSpace;
        this.unloadOrder = unloadOrder;
    }

    void addToStorage(Vehicle vehicle) {
        if (currentFillAmount + vehicle.getSize() <= maxSpace && vehicle.getSize() <= largestLoadingSize) {
            currentStorage.add(vehicle);
            currentFillAmount += vehicle.getSize();
        }
    }

    Vehicle removeFromStorage() {
        if (unloadOrder.equals(UnloadOrder.firstInFirstOut)) {
            return unloadFirstInFirstOut();
        }
        return null;
    }

    private Vehicle unloadFirstInFirstOut() {
        return currentStorage.remove(0);
        //The car should be unloaded to a coordinate somewhere behind the storage.
        //(Distance selectable when creating storage?)
    }

    void moveStorage(double x, double y, double direction) {
        for (Vehicle vehicle : currentStorage) {
            vehicle.followStorage(x, y, direction);
        }
    }
}
