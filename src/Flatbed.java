/**
 * A class for flatbed used in TransportTruck and ScaniaTruck with the help of delegation.
 */
class Flatbed {
    /**
     * flatbedAngle used in method: setFlatbedAngle().
     */
    private double flatBedAngle = 0;
    private double flatBedMaxAngle;
    private double flatBedMovementSpeed;
    private double maxSpeedLock;

    /**
     *
     * @param flatBedMovementSpeed The speed for a flatbed to move.
     * @param flatBedMaxAngle "Closed" flatbed.
     * @param maxSpeedLock The max speed for a vehicle to open/close the flatbed.
     */
    Flatbed(double flatBedMovementSpeed, double flatBedMaxAngle, double maxSpeedLock) {
        this.flatBedMovementSpeed = flatBedMovementSpeed;
        this.flatBedMaxAngle = flatBedMaxAngle;
        this.maxSpeedLock = maxSpeedLock;
    }

    /**
     * Raises the flatbed if the vehicle's speed equals or is lower than the max speed lock and the flatbed angle is smaller than max.
     * @param currentSpeed The vehicle's current speed.
     */
    void raiseFlatBed(double currentSpeed) {
        if(flatBedAngle < flatBedMaxAngle && currentSpeed <= maxSpeedLock) {
            setFlatBedAngle(flatBedMovementSpeed);
        }
    }

    /**
     * Lowers the flatbed if the vehicle's speed equals or is lower than the max speed lock and the flatbed angle is larger than min.
     * @param currentSpeed The vehicle's current speed.
     */
    void lowerFlatBed(double currentSpeed) {
        if(flatBedAngle>0 && currentSpeed <= maxSpeedLock) {
            setFlatBedAngle(-flatBedMovementSpeed); }
    }

    /**
     * Returns true if the flatbed angle is max.
     * @return true/false
     */
    boolean isMax() { return flatBedAngle>=flatBedMaxAngle; }

    /**
     * Returns true if the flatbed angle is min.
     * @return true/false
     */
    boolean isLowest() { return flatBedAngle<=0; }

    /**
     * Sets the flatbed angle: closed/opened.
     * @param flatBedSpeed
     */
    private void setFlatBedAngle(double flatBedSpeed) {
        if(this.flatBedAngle+flatBedSpeed >= flatBedMaxAngle){ //if it's closed
            this.flatBedAngle = flatBedMaxAngle;
        }
        else if(this.flatBedAngle+flatBedSpeed<=0){ //if it's opened
            this.flatBedAngle = 0;
        }
        else{
            this.flatBedAngle += flatBedSpeed; //closes/opens
        }

    }
}
