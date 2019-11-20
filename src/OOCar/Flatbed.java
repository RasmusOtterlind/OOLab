package OOCar;

class Flatbed {
    private double flatBedAngle = 0;
    private double flatBedMaxAngle;
    private double flatBedMovementSpeed;
    private double maxSpeedLock;

    Flatbed(double flatBedMovementSpeed, double flatBedMaxAngle, double maxSpeedLock) {
        this.flatBedMovementSpeed = flatBedMovementSpeed;
        this.flatBedMaxAngle = flatBedMaxAngle;
        this.maxSpeedLock = maxSpeedLock;
    }

    void raiseFlatBed(double currentSpeed) {
        if(flatBedAngle < flatBedMaxAngle && currentSpeed <= maxSpeedLock) {
            setFlatBedAngle(flatBedMovementSpeed);
        }
    }

    void lowerFlatBed(double currentSpeed) {
        if(flatBedAngle>0 && currentSpeed <= maxSpeedLock) {
            setFlatBedAngle(-flatBedMovementSpeed); }
    }

    boolean isMax() { return flatBedAngle>=flatBedMaxAngle; }

    boolean isLowest() { return flatBedAngle<=0; }

    private void setFlatBedAngle(double flatBedAngle) {
        if(this.flatBedAngle+flatBedAngle >= flatBedMaxAngle){
            flatBedAngle = flatBedMaxAngle;
            this.flatBedAngle = flatBedAngle;
        }
        else if(this.flatBedAngle+flatBedAngle<=0){
            flatBedAngle = 0;
            this.flatBedAngle = flatBedAngle;
        }
        else{
            this.flatBedAngle += flatBedAngle;
        }

    }
}
