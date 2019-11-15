package OOCar;

import java.awt.*;

public class ScaniaTruck extends Vehicle implements IFlatbed {
    private double flatBedAngle = 0;
    ScaniaTruck() {
        super(2, 110, 0, Color.BLACK, "ScaniaTruck",0.2);
    }
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

    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01;
    }

    @Override
    public void raiseFlatBed() { if(flatBedAngle<70 && getCurrentSpeed()==0){ flatBedAngle += 5; } }
    @Override
    public void lowerFlatBed() { if(flatBedAngle>0){ flatBedAngle -= 5; } }

    @Override
    public boolean isMax() { return flatBedAngle>=70; }

    @Override
    public boolean isLowest() { return flatBedAngle<=0; }

}
