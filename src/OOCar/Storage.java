package OOCar;

import java.util.ArrayList;
import java.util.List;

class Storage <T extends Vehicle>{

    enum UnloadOrder {
        firstInFirstOut, lastInFirstOut, selected
    }
    private double maxSpace;
    private double largestLoadingSize;
    private double loadingRadius;
    private double currentFillAmount = 0;
    private UnloadOrder unloadOrder;
    private List<T> currentStorage = new ArrayList<>();

    Storage(int maxSpace, UnloadOrder unloadOrder, double largestLoadingSize) { //Should probably create value of largestLoadingSize in here too
        this.maxSpace = maxSpace;
        this.unloadOrder = unloadOrder;
        this.largestLoadingSize = largestLoadingSize;
    }

    void addToStorage(T vehicle, double x ,double y,double direction) { //Void Boolean instead?
        if (currentFillAmount + vehicle.getSize() <= maxSpace && vehicle.getSize() <= largestLoadingSize
                && (x-loadingRadius<=vehicle.getX() && vehicle.getX() >=x+loadingRadius)&& (y-loadingRadius<=vehicle.getY() && vehicle.getY() >=y+loadingRadius)){
            currentStorage.add(vehicle);
            currentFillAmount += vehicle.getSize();
            vehicle.followStorage(x,y,direction);
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

            if (vehicle instanceof IStorage) {
                ((IStorage) vehicle).moveStorage();
            }
        }
    }
}
