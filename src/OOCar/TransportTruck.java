package OOCar;

import java.awt.*;

public class TransportTruck extends Vehicle implements IFlatbed {
    private Flatbed flatbed = new Flatbed(1, 100, 0);

    TransportTruck() {
        super(2, 200, 0, Color.magenta, "TransportTruck-2000", 0.05);
    }

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.003;
    }

    public void raiseFlatBed() {
        flatbed.raiseFlatBed(getCurrentSpeed());
    }

    public void lowerFlatBed() {
        flatbed.lowerFlatBed(getCurrentSpeed());
    }

    public boolean isMax() {return flatbed.isMax();}

    public boolean isLowest() {return flatbed.isLowest();}
}
