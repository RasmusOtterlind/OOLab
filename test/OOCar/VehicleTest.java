package OOCar;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

/**
 * test's different functions of the vehicles
 */
public class VehicleTest {

    @Test
    public void move() {
        Vehicle c = new Saab95();
        double x = c.getX();
        double y = c.getY();
        c.startEngine();
        c.turnLeft();
        c.gas(1);
        c.move();
        assertTrue(c.getX() != x && c.getY() != y);
    }

    @Test
    public void turnLeft() {                                                                                    //kolla vänster
        Vehicle c = new Saab95();
        c.startEngine();
        c.gas(1);
        c.turnLeft();
        c.move();
        assertTrue(c.getY()>0);
    }

    @Test
    public void turnRight() {                                                                                   //kolla höger
        Vehicle c = new Saab95();
        c.startEngine();
        c.gas(1);
        c.turnRight();
        c.move();
        assertTrue(c.getY()<0);
    }

    @Test
    public void gas() {
        Vehicle c = new Volvo240();
        c.startEngine();
        double d = c.getCurrentSpeed();
        c.gas(1);
        assertTrue(c.getCurrentSpeed()>d);
    }
    @Test
    public void brake() {
        Vehicle c = new Volvo240();
        c.startEngine();
        c.gas(1);
        double speed = c.getCurrentSpeed();
        System.out.println(c.getCurrentSpeed());
        c.brake(0.5);
        System.out.println(c.getCurrentSpeed());
        assertTrue(c.getCurrentSpeed()<speed);
    }
    @Test
    public void transportUpdatePosition(){
        TransportTruck t = new TransportTruck();
        Vehicle c = new Volvo240();
        t.startEngine();
        c.startEngine();
        t.lowerFlatBed();
        t.addToStorage(c);
        t.raiseFlatBed();
        t.startEngine();
        t.move();
        assertTrue(c.getX()>0);
    }


    @Test
    public void startEngine() {
        ScaniaTruck t = new ScaniaTruck();
        t.raiseFlatBed();
        t.startEngine();
        System.out.println(t.getCurrentSpeed());
        assertTrue(t.getCurrentSpeed() > 0);
    }

    @Test
    public void incrementSpeed() {
        Vehicle c = new Volvo240();
        c.startEngine();
        c.gas(1);
        double d = c.getCurrentSpeed();
        c.gas(1);
        assertTrue(c.getCurrentSpeed()>d);
    }

    @Test
    public void color() {
        ScaniaTruck t = new ScaniaTruck();
        t.setColor(Color.red);
        assertSame(t.getColor(), Color.red);
    }
    @Test
    public void turbo() {
        Saab95 sab1 = new Saab95();
        sab1.setTurboOn();
        sab1.startEngine();
        sab1.gas(1);
        sab1.move();
        Saab95 sab2 = new Saab95();
        sab2.setTurboOff();
        sab2.startEngine();
        sab2.gas(1);
        sab2.move();
        assertTrue(sab1.getX()>sab2.getX());
    }
}