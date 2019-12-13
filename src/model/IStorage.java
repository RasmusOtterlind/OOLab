package model;

/**
 * An interface to help use Polymorphism when moving loaded vehicles
 * @param <T>
 */
public interface IStorage<T extends Vehicle> {
    /**
     * method that moves the given vehicles storage
     */
    void moveStorage();

    /**
     * adds specific vehicle to storage
     * @param IVehicle
     */
    void addToStorage(T IVehicle);
    void unloadStorage();
}
