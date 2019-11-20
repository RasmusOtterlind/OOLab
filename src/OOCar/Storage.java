package OOCar;

import java.util.ArrayList;
import java.util.List;

class Storage {

    enum UnloadOrder {
        firstInFirstOut, lastInFirstOut, selected;
    }
    private int maxSpace;
    private UnloadOrder unloadOrder;
    private List<Vehicle> currentStorage = new ArrayList<>();

    Storage(int maxSpace, UnloadOrder unloadOrder) {
        this.maxSpace = maxSpace;
        this.unloadOrder = unloadOrder;
    }

    void addToStorage(Vehicle vehicle) {
        if (currentStorage.size() < maxSpace) {
            currentStorage.add(vehicle);
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
        for (Vehicle type : currentStorage) {
            type.followStorage(x, y, direction);
        }
    }
}
