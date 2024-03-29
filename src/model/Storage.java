package model;

import java.util.ArrayList;
import java.util.List;

/**
 * A class that can be specified to only receive vehicles of specific types.
 * @param <T> Vehicle type
 */
class Storage <T extends Vehicle>{

    /**
     * Specifies in what order you can unload the vehicles.
     */
    enum UnloadOrder {
        firstInFirstOut, lastInFirstOut, selected
    }
    private double maxSpace;
    private double largestLoadingSize;
    private double loadingRadius;
    private double currentFillAmount = 0;
    private UnloadOrder unloadOrder;
    private List<T> currentStorage = new ArrayList<>();

    /**
     *
     * @param maxSpace Max space in storage.
     * @param unloadOrder The order to unload vehicles from the storage.
     * @param largestLoadingSize The largest vehicle size a storage can receive.
     */
    Storage(int maxSpace, UnloadOrder unloadOrder, double largestLoadingSize, double loadingRadius) { //Should probably create value of largestLoadingSize in here too
        this.maxSpace = maxSpace;
        this.unloadOrder = unloadOrder;
        this.largestLoadingSize = largestLoadingSize;
        this.loadingRadius = loadingRadius;
    }

    /**
     * Checks if the vehicle to load is in the same radius as the storage.
     * @param x The transport truck's or service station's x-coordinate.
     * @param y The transport truck's or service station's y-coordinate.
     * @param vehicle The vehicle you want to check and load.
     * @return true/false
     */
    private boolean inRadius(double x ,double y,Vehicle vehicle){
        return Math.abs(x - vehicle.getX()) < loadingRadius && Math.abs(y - vehicle.getY()) < loadingRadius;
    }

    /**
     * Add vehicle to storage.
     * @param vehicle The vehicle to load.
     * @param x The transport truck's or service station's x-coordinate.
     * @param y The transport truck's or service station's y-coordinate.
     * @param direction The transport trucks's or service station's direction.
     */
    boolean addToStorage(T vehicle, double x ,double y, double direction) { //Void Boolean instead?
        if (currentFillAmount + vehicle.getSize() <= maxSpace && vehicle.getSize() <= largestLoadingSize && inRadius(x,y,vehicle)){
            currentFillAmount += vehicle.getSize();
            vehicle.updatePosition(x,y,direction,true);
            currentStorage.add(vehicle);
            return true;
        }
        return false;
    }

    /**
     * Unload vehicle from the storage
     * @param x The loaded vehicle's and transport/service station's x-coordinate.
     * @param y The loaded vehicle's and transport/service station's y-coordinate.
     * @param direction The loaded vehicle's and transport/service station's direction.
     */
    void unloadSpecificStorage(double x, double y, double direction) {
        if(!currentStorage.isEmpty()) {
            if(unloadOrder == UnloadOrder.firstInFirstOut){
                currentFillAmount -= currentStorage.get(currentStorage.size()-1).getSize();
                currentStorage.get(currentStorage.size()-1).updatePosition(x-10,y-10,direction,false);
                Vehicle v = currentStorage.get(currentStorage.size()-1);
                currentStorage.remove(currentStorage.size()-1);
            }
            else if(unloadOrder == UnloadOrder.lastInFirstOut){
                currentFillAmount -= currentStorage.get(0).getSize();
                currentStorage.get(0).updatePosition(x-10,y-10,direction,false);
                Vehicle v = currentStorage.get(0);
                currentStorage.remove(0);
            }

        }
       //The car should be unloaded to a coordinate somewhere behind the storage.
        //(Distance selectable when creating storage?)
    }
    /**
     * Unload vehicle from the storage
     * @param x The loaded vehicle's and transport/service station's x-coordinate.
     * @param y The loaded vehicle's and transport/service station's y-coordinate.
     * @param direction The loaded vehicle's and transport/service station's direction.
     * @param vehicle the specific vehicle you want to unload
     */
    void unloadSpecificStorage(double x, double y, double direction, T vehicle){
        if(!currentStorage.isEmpty() && unloadOrder == UnloadOrder.selected && currentStorage.contains(vehicle)){
            currentFillAmount -= vehicle.getSize();
            currentStorage.remove(vehicle);
            vehicle.updatePosition(x-10,y-10,direction,false);
        }
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
