

import model.*;
import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * test's different functions of the vehicles
 */
public class VehicleTest {
    ArrayList<IVehicle> vehicleList = new ArrayList<>();

    @Test
    public void move() {
        IVehicle c = VehicleFactory.createSaab95(0,0,0);
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
        IVehicle c = VehicleFactory.createSaab95(0,0,0);
        c.startEngine();
        c.gas(1);
        c.turnLeft();
        c.move();
        assertTrue(c.getY()!=0);
    }

    @Test
    public void turnRight() {                                                                                   //kolla höger
        IVehicle c = VehicleFactory.createSaab95(0,0,0);
        c.startEngine();
        c.gas(1);
        c.turnRight();
        c.move();

        assertTrue(c.getY()!=0);
    }

    @Test
    public void gas() {
        IVehicle c = VehicleFactory.createSaab95(0,0,0);
        c.startEngine();
        double d = c.getCurrentSpeed();
        c.gas(1);
        assertTrue(c.getCurrentSpeed()>d);
    }
    @Test
    public void brake() {
        IVehicle c = VehicleFactory.createVolvo240(0,0,0);
        c.startEngine();
        c.gas(1);
        double speed = c.getCurrentSpeed();
        System.out.println(c.getCurrentSpeed());
        c.brake(0.5);
        System.out.println(c.getCurrentSpeed());
        assertTrue(c.getCurrentSpeed()<speed);
    }
    /*
    @Test
    public void transport(){
        IVehicle t = VehicleFactory.createTransportTruck(0,0,0);
        IVehicle c = VehicleFactory.createSaab95(0,0,0);
        IVehicle c2 = VehicleFactory.createVolvo240(0,0,0);

        for (int i = 0; i < 1000; i++) {
            if (!t.isLowest()){
                t.lowerFlatBed();
            }
        }

        (IStorage) t.addToStorage(c);
        t.addToStorage(c2);

        for (int i = 0; i < 1000; i++) {
            if (!t.isMax()){
                t.raiseFlatBed();
            }
        }
        t.startEngine();
        t.gas(1);
        t.move();
        assertTrue(c.getX()>0 && c2.getX() == 100);
    }


    @Test
    public void startEngine() {
        ScaniaTruck t = new ScaniaTruck(0,0,0);
        t.raiseFlatBed();
        t.startEngine();
        System.out.println(t.getCurrentSpeed());
        assertTrue(t.getCurrentSpeed() > 0);
    }

    @Test
    public void incrementSpeed() {
        Vehicle c = new Volvo240(0,0,0);
        c.startEngine();
        c.gas(1);
        double d = c.getCurrentSpeed();
        c.gas(1);
        assertTrue(c.getCurrentSpeed()>d);
    }

    @Test
    public void color() {
        ScaniaTruck t = new ScaniaTruck(0,0,0);
        t.setColor(Color.red);
        assertSame(t.getColor(), Color.red);
    }
    @Test
    public void turbo() {
        Saab95 sab1 = new Saab95(0,0,0);
        sab1.setTurboOn();
        sab1.startEngine();
        sab1.gas(1);
        sab1.move();
        Saab95 sab2 = new Saab95(0,0,0);
        sab2.setTurboOff();
        sab2.startEngine();
        sab2.gas(1);
        sab2.move();
        assertTrue(sab1.getX()>sab2.getX());
    }

     */


}