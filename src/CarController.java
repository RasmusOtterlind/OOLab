import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    /**
     * buttons
     */
    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Scania Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Lift Bed");
    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");
    private ArrayList<JButton> buttonsList = new ArrayList<>();
    // member fields
    // The delay (ms) corresponds to 20 updates a sec (hz)
    //private final int delay = 13;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    //private Timer timer = new Timer(delay, new TimerListener());
    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    // A list of cars, modify if needed
    private CarModel model = new CarModel();
    public CarController() {
        buttonsList.add(gasButton);
        buttonsList.add(brakeButton);
        buttonsList.add(turboOnButton);
        buttonsList.add(turboOffButton);
        buttonsList.add(liftBedButton);
        buttonsList.add(lowerBedButton);
        gasButton.addActionListener(e -> model.gas(frame.getGasAmount()));
        startButton.addActionListener(e -> model.startCars());
        brakeButton.addActionListener(e -> model.brake(frame.getGasAmount()));
        turboOnButton.addActionListener(e ->model.turboOn());
        turboOffButton.addActionListener(e -> model.turboOff());
        liftBedButton.addActionListener(e -> model.liftBed());
        lowerBedButton.addActionListener(e ->model.lowerBed());
        stopButton.addActionListener(e -> model.stopCars());
        frame = new CarView("hej",buttonsList);
        stopButton.setPreferredSize(new Dimension(frame.getWidth()/5-15,200));
        startButton.setPreferredSize(new Dimension(frame.getWidth()/5-15,200));
        frame.add(startButton);
        frame.add(stopButton);
    }

//methods:
/*
    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(VehicleFactory.createSaab95(100,100,0));
        cc.vehicles.add(VehicleFactory.createVolvo240(100,200,0));
        cc.vehicles.add(VehicleFactory.createScaniaTruck(100,300,0));

        // Start a new view and send a reference of self
        //cc.frame = new CarView("CarSim 1.0",cc.buttonsList);



        // Start the timer
        cc.timer.start();
    }

 */

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * *//*
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
    */

    // Calls the gas method for each car once


}
