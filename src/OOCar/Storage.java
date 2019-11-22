package OOCar;

import java.util.ArrayList;
import java.util.List;

class Storage <T extends Vehicle>{

    enum UnloadOrder {
        firstInFirstOut, lastInFirstOut, selected
    }
    private double maxSpace;
    private double largestLoadingSize;
    private double currentFillAmount = 0;
    private UnloadOrder unloadOrder;
    private List<T> currentStorage = new ArrayList<>();

    Storage(int maxSpace, UnloadOrder unloadOrder, double largestLoadingSize) { //Should probably create value of largestLoadingSize in here too
        this.maxSpace = maxSpace;
        this.unloadOrder = unloadOrder;
        this.largestLoadingSize = largestLoadingSize;
    }

    void addToStorage(T vehicle, double x ,double y, double direction) { //Void Boolean instead?
        if (currentFillAmount + vehicle.getSize() <= maxSpace && vehicle.getSize() <= largestLoadingSize) {
            currentStorage.add(vehicle);
            currentFillAmount += vehicle.getSize();
            vehicle.updatePosition(x,y,direction);
        }
    }

    Vehicle unloadStorage() {
        return currentStorage.remove(0);
        //The car should be unloaded to a coordinate somewhere behind the storage.
        //(Distance selectable when creating storage?)
    }

    /**
     * Calls updatePosition on all vehicles inside the storage,
     * also calls moveStorage on all IStorage vehicles.
     * @param x
     * @param y
     * @param direction
     */
    void moveStorage(double x, double y, double direction) {

        for (Vehicle vehicle : currentStorage) {
            vehicle.updatePosition(x, y, direction);

            if (vehicle instanceof IStorage) {
                ((IStorage) vehicle).moveStorage();
            }
        }
    }
}
