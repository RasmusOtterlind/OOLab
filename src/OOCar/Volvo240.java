package OOCar;

import java.awt.*;

/**
 * Volvo240 a subclass to car. A car with Trimfactor and some preset characteristics
 */
public class  Volvo240 extends Vehicle {

    private final static double trimFactor = 1.25;

    public Volvo240(){
        super(4,100.0,0.0,Color.BLACK,"Volvo240",1.0,1);
        stopEngine();
    }

    /**
     * Volvo's speedFactor
     * @return
     */
    public double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }
}
