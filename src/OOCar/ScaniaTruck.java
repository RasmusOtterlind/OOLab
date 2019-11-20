package OOCar;

import java.awt.*;

public class ScaniaTruck extends Vehicle implements IFlatbed {
    private Flatbed flatbed = new Flatbed(1, 100, 0);

    ScaniaTruck() {
        super(2, 110, 0, Color.BLACK, "ScaniaTruck",0.2);
    }

    @Override
    public double speedFactor() {
        if (isLowest()) {
            return getEnginePower() * 0.01;
        }
        return 0;
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
