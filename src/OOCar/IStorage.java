package OOCar;

interface IStorage<T extends Vehicle> {
    void moveStorage();
    void addToStorage(T vehicle);
    Vehicle unloadStorage();
}
