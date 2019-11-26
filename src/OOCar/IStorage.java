package OOCar;

/**
 * An interface to help use Polymorphism when moving loaded vehicles
 * @param <T>
 */
interface IStorage<T extends Vehicle> {
    /**
     * method that moves the given vehicles storage
     */
    void moveStorage();

    /**
     * adds specific vehicle to storage
     * @param vehicle
     */
    void addToStorage(T vehicle);
    void unloadStorage();
}
