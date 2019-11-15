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
        c.turnLeft();
        c.gas(1);
        c.move();
        assertTrue(c.getX() != x && c.getY() != y);
    }

    @Test
    public void turnLeft() {                                                                                    //kolla vänster
        Vehicle c = new Saab95();
        c.gas(1);
        c.turnLeft();
        c.move();
        assertTrue(c.getY()>0);
    }

    @Test
    public void turnRight() {                                                                                   //kolla höger
        Vehicle c = new Saab95();
        c.gas(1);
        c.turnRight();
        c.move();
        assertTrue(c.getY()<0);
    }
    @Test
    public void gas() {
        Vehicle c = new Volvo240();
        double d = c.getCurrentSpeed();
        c.gas(1);
        assertTrue(c.getCurrentSpeed()>d);
    }
    @Test
    public void brake() {
        Vehicle c = new Volvo240();
        c.gas(1);
        c.gas(1);
        double speed = c.getCurrentSpeed();
        System.out.println(c.getCurrentSpeed());
        c.brake(1);
        System.out.println(c.getCurrentSpeed());
        assertTrue(c.getCurrentSpeed()<speed);
    }
    @Test
    public void raiseFlatBed(){
        ScaniaTruck t = new ScaniaTruck();
        double angle = t.getFlatBedAngle();
        t.raiseFlatBed();
        assertTrue(t.getFlatBedAngle()>angle);
    }
    @Test
    public void lowerFlatBed(){
        ScaniaTruck t = new ScaniaTruck();
        t.raiseFlatBed();t.raiseFlatBed();
        double angle = t.getFlatBedAngle();
        t.lowerFlatBed();
        assertTrue(t.getFlatBedAngle()<angle);
    }
    @Test
    public void isMax(){
        ScaniaTruck t = new ScaniaTruck();
        t.setFlatBedAngle(100);
        System.out.println(t.getFlatBedAngle());

        assertTrue(t.isMax());
    }
    @Test
    public void startEngine() {
        ScaniaTruck t = new ScaniaTruck();
        t.startEngine();
        System.out.println(t.getCurrentSpeed());
        assertTrue(t.getCurrentSpeed() == 0.1);
    }

    @Test
    public void isLowest(){
        ScaniaTruck t = new ScaniaTruck();
        t.setFlatBedAngle(-100);
        System.out.println(t.getFlatBedAngle());

        assertTrue(t.isLowest());
    }

    @Test
    public void color() {
        ScaniaTruck t = new ScaniaTruck();
        t.setColor(Color.red);
        assertTrue(t.getColor() == Color.red);
    }
}