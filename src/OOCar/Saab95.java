package OOCar;

import java.awt.*;

/**
 * Saab95 a subclass to car. A car with Turbo and some preset characteristics
 */
public class Saab95 extends Vehicle {

    private boolean turboOn;
    public Saab95(){
        super(2,125.0,0.0,Color.red,"Saab95",1.0,1);
        stopEngine();
    }
    public void setTurboOn(){ turboOn = true; }
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Saab95's speedFactor determined by if turbo is on or off
     * @return
     */
    public double speedFactor(){
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
    

}
