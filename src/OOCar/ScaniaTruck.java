package OOCar;

import java.awt.*;

/**
 * A subclass to Vehicle.
 */
public class ScaniaTruck extends Vehicle {
    /**
     * Composition: Creating new object flatbed to reach method in the class Flatbed with the help of delegation.
     */
    private Flatbed flatbed = new Flatbed(100, 100, 0);

    ScaniaTruck(double x, double y, double direction) {
        super(x, y, direction,2, 110, 0, Color.BLACK, "ScaniaTruck",0.2,3);
    }

    /**
     * Increases the speed if the flatbed is in its max position (closed).
     * @return
     */
    @Override
    public double speedFactor() {
        if (isMax()) {
            return getEnginePower() * 0.01;
        }
        return 0;
    }

    /**
     * Created a method to use a method in the class Flatbed.
     */
    public void raiseFlatBed() {
        flatbed.raiseFlatBed(getCurrentSpeed());
    }

    /**
     * Created a method to use a method in the class Flatbed.
     */
    public void lowerFlatBed() {
        flatbed.lowerFlatBed(getCurrentSpeed());
    }

    /**
     * Created a method to use a method in the class Flatbed.
     * @return
     */
    public boolean isMax() {return flatbed.isMax();}

    /**
     * Created a method to use a method in the class Flatbed.
     * @return
     */
    public boolean isLowest() {return flatbed.isLowest();}

}
