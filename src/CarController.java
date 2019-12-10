import model.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 13;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    private ArrayList<IVehicle> vehicles = new ArrayList<>();



    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(VehicleFactory.createSabb95(100,100,0));
        cc.vehicles.add(VehicleFactory.createVolvo240(100,200,0));
        cc.vehicles.add(VehicleFactory.createScaniaTruck(100,300,0));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");
        cc.frame.gasButton.addActionListener(e -> cc.gas(cc.frame.getGasAmount()));
        cc.frame.startButton.addActionListener(e -> cc.startCars());
        cc.frame.brakeButton.addActionListener(e -> cc.brake(cc.frame.getGasAmount()));
        cc.frame.turboOnButton.addActionListener(e ->cc.turboOn());
        cc.frame.turboOffButton.addActionListener(e -> cc.turboOff());
        cc.frame.liftBedButton.addActionListener(e -> cc.liftBed());
        cc.frame.lowerBedButton.addActionListener(e ->cc.lowerBed());
        cc.frame.stopButton.addActionListener(e -> cc.stopCars());

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle car : vehicles){
                car.move();
                changeDirectionIfOut(car);
                //int x = (int) Math.round(car.getX());
                //int y = (int) Math.round(car.getY());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
            frame.drawPanel.moveIt(vehicles);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle car : vehicles
                ) {
            car.gas(gas);
        }
    }
    void startCars(){
        for(IVehicle car : vehicles){
            car.startEngine();
        }
    }
   void brake(int amount){
       double brake = ((double) amount) / 100;
        for (IVehicle car : vehicles){
            car.brake(brake);
        }
   }
   void turboOn(){
        for(IVehicle vehicle : vehicles) {
            if (vehicle instanceof ITurbo) {
                ((ITurbo)vehicle).setTurboOn();
            }
        }
   }
   void turboOff(){
       for(IVehicle vehicle : vehicles) {
           if (vehicle instanceof ITurbo) {
               ((ITurbo)vehicle).setTurboOff();
           }
       }
   }
   void liftBed(){
        for(IVehicle vehicle : vehicles){
            if (vehicle instanceof IFlatBed) {
                ((IFlatBed)vehicle).raiseFlatBed();
            }
        }
   }
    void lowerBed(){
        for(IVehicle vehicle : vehicles){
            if (vehicle instanceof IFlatBed) {
                ((IFlatBed)vehicle).lowerFlatBed();
            }
        }
    }
    void stopCars(){
        for(IVehicle vehicle : vehicles){
            vehicle.stopEngine();
        }

    }

   private void changeDirectionIfOut(IVehicle vehicle){
        if(checkIfOut(vehicle)){
            vehicle.setDirection(vehicle.getDirection()+Math.PI);
        }
   }
   private boolean checkIfOut(IVehicle entity){
        if((entity.getX()<=0|| entity.getX()>=700) || entity.getY()<=30 || entity.getY()>=500){
            return true;
        }
        return false;
   }

}
