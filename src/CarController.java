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
    private ArrayList<Vehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(100,100,0));
        cc.cars.add(new Saab95(100,200,0));
        cc.cars.add(new ScaniaTruck(200,200,Math.PI));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars){
                car.move();
                changeDirectionIfOut(car);
                //int x = (int) Math.round(car.getX());
                //int y = (int) Math.round(car.getY());
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
            frame.drawPanel.moveit(cars);
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
                ) {
            car.gas(gas);
        }
    }
    void startCars(){
        for(Vehicle car : cars){
            car.startEngine();
        }
    }
   void brake(int amount){
       double brake = ((double) amount) / 100;
        for (Vehicle car : cars ){
            car.brake(brake);
            System.out.println("hälsa mormor");
        }
   }
   void turboOn(){
        for(Vehicle vehicle : cars) {
            if (vehicle instanceof Saab95) {
                ((Saab95)vehicle).setTurboOn();
            }
        }
   }
   void turboOff(){
       for(Vehicle vehicle : cars) {
           if (vehicle instanceof Saab95) {
               ((Saab95)vehicle).setTurboOff();
           }
       }
   }
   void liftBed(){
        for(Vehicle vehicle : cars){
            if (vehicle instanceof IFlatBed) {
                ((IFlatBed)vehicle).raiseFlatBed();
            }
        }
   }
    void lowerBed(){
        for(Vehicle vehicle : cars){
            if (vehicle instanceof IFlatBed) {
                ((IFlatBed)vehicle).lowerFlatBed();
            }
        }
    }
    void stopCars(){
        for(Vehicle vehicle : cars){
            vehicle.stopEngine();
        }

    }

   private void changeDirectionIfOut(WorldObject vehicle){
        if(checkIfOut(vehicle)){
            vehicle.setDirection(vehicle.getDirection()+Math.PI);
        }
   }
   private boolean checkIfOut(WorldObject entity){
        if((entity.getX()<=0|| entity.getX()>=700) || entity.getY()<=30 || entity.getY()>=500){
            return true;
        }
        return false;
   }

}