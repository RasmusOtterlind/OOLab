package model;

import java.awt.*;

/**
 * Saab95 a subclass to car. A car with Turbo and some preset characteristics
 */
 class Saab95 extends Vehicle implements ITurbo {

    private boolean turboOn;
    Saab95(double x, double y, double direction){
        super(x, y, direction,2,125.0,0.0,Color.red,"Saab95",0.4,1);
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
