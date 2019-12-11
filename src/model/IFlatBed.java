package model;

public interface IFlatBed extends IVehicle {
    void raiseFlatBed();
    void lowerFlatBed();
    boolean isMax();
    boolean isLowest();
}
