package OOCar;

import java.awt.*;

public class TransportTruck extends Vehicle implements IFlatbed{
    private double flatBedAngle = 0;
    private TruckRampHelper truckRampHelper = new TruckRampHelper(1, 100, 0);

    TransportTruck() {
        super(2, 200, 0, Color.magenta, "TransportTruck-2000", 0.05);
    }

    public double speedFactor() {
        return getEnginePower() * 0.003;

    }

    @Override
    public void raiseFlatBed() {
        truckRampHelper.raiseFlatBed(getCurrentSpeed());
    }

    @Override
    public void lowerFlatBed() {

    }

    @Override
    public boolean isMax() {
        return false;
    }

    @Override
    public boolean isLowest() {
        return false;
    }
}
