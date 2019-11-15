package OOCar;

public class TruckRampHelper implements IFlatbed {
    private double flatBedAngle = 0;
    private double flatBedMaxAngle;
    private double flatBedMovementSpeed;
    private double maxSpeedLock;

    public TruckRampHelper(double flatBedMovementSpeed, double flatBedMaxAngle, double maxSpeedLock) {
        this.flatBedMovementSpeed = flatBedMovementSpeed;
        this.flatBedMaxAngle = flatBedMaxAngle;
        this.maxSpeedLock = maxSpeedLock;
    }

    @Override
    public void raiseFlatBed(double currentSpeed) {
        if(flatBedAngle < 70 && currentSpeed == maxSpeedLock) {
        setFlatBedAngle(flatBedMovementSpeed);
        }
    }

    @Override
    public void lowerFlatBed() {
        if(flatBedAngle>0) {
            setFlatBedAngle(-flatBedMovementSpeed); }
    }

    @Override
    public boolean isMax() { return flatBedAngle>=flatBedMaxAngle; }

    @Override
    public boolean isLowest() { return flatBedAngle<=0; }

    public double getFlatBedAngle() {
        return flatBedAngle;
    }

    public void setFlatBedAngle(double flatBedAngle) {
        if(flatBedAngle > flatBedMaxAngle){
            flatBedAngle = flatBedMaxAngle;
        }
        else if(flatBedAngle<0){
            flatBedAngle = 0;
        }
        this.flatBedAngle = flatBedAngle;
    }
}
