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
    private boolean inRadius(double x ,double y,T vehicle){
        if(x-loadingRadius<=vehicle.getX() && vehicle.getX() >=x+loadingRadius && (y-loadingRadius<=vehicle.getY() && vehicle.getY() >=y+loadingRadius)){

        }
        return false;
    }

    void addToStorage(T vehicle, double x ,double y, double direction) { //Void Boolean instead?
        if (currentFillAmount + vehicle.getSize() <= maxSpace && vehicle.getSize() <= largestLoadingSize && inRadius(x,y,vehicle));{
            currentFillAmount += vehicle.getSize();
            vehicle.updatePosition(x,y,direction,true);
        }
    }

   public Vehicle unloadStorage(double x,double y,double direction) {
        if(!currentStorage.isEmpty()) {
            if(unloadOrder == UnloadOrder.firstInFirstOut){
                currentFillAmount -= currentStorage.get(currentStorage.size()-1).getSize();
                currentStorage.get(currentStorage.size()-1).updatePosition(x-10,y-10,direction,false);
                Vehicle v = currentStorage.get(currentStorage.size()-1);
                currentStorage.remove(currentStorage.size()-1);
                return v;
            }
            else if(unloadOrder == UnloadOrder.lastInFirstOut){
                currentFillAmount -= currentStorage.get(0).getSize();
                currentStorage.get(0).updatePosition(x-10,y-10,direction,false);
                Vehicle v = currentStorage.get(0);
                currentStorage.remove(0);
                return v;
            }

        }
        return null;
        //The car should be unloaded to a coordinate somewhere behind the storage.
        //(Distance selectable when creating storage?)
    }
    public Vehicle unloadStorage(double x,double y,double direction,T vehicle){
        if(!currentStorage.isEmpty() && unloadOrder == UnloadOrder.selected){
            currentFillAmount -= vehicle.getSize();
            currentStorage.remove(vehicle);
            vehicle.updatePosition(x-10,y-10,direction,false);
            return vehicle;
        }
        return null;
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
            vehicle.updatePosition(x, y, direction,true);

            if (vehicle instanceof IStorage) {
                ((IStorage) vehicle).moveStorage();
            }
        }
    }
}
