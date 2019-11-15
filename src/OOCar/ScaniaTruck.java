package OOCar;

import java.awt.*;

public class ScaniaTruck extends Vehicle implements IFlatbed {
    private double flatBedAngle = 0;

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

    @Override
    public void raiseFlatBed() { if(flatBedAngle<70 && getCurrentSpeed()==0){ flatBedAngle += 5; } }

    @Override
    public void lowerFlatBed() { if(flatBedAngle>0){ flatBedAngle -= 5; } }

    @Override
    public boolean isMax() { return flatBedAngle>=70; }

    @Override
    public boolean isLowest() { return flatBedAngle<=0; }

    public double getFlatBedAngle() {
        return flatBedAngle;
    }

    public void setFlatBedAngle(double flatBedAngle) {
        if(flatBedAngle > 70){
            flatBedAngle = 70;
        }
        else if(flatBedAngle<0){
            flatBedAngle = 0;
        }
        this.flatBedAngle = flatBedAngle;
    }

}
