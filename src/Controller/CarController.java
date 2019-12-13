package Controller;

import View.CarView;
import model.CarModel;


/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements AnimateListener {
    /**
     * The main frame for the graphics of the cars and buttons
     */
    private CarView frame;
    private CarModel model;
    public CarController(CarModel model) {
        this.model = model;
        frame = new CarView("God game x2000");
        addActionListeners();
        model.addListener(this);
    }

    /**
     * adds actionListeners to the buttons
     */
    private void addActionListeners(){
        frame.getGasButton().addActionListener(e -> model.gas(frame.getGasAmount()));
        frame.getStartButton().addActionListener(e -> model.startCars());
        frame.getBrakeButton().addActionListener(e -> model.brake(frame.getGasAmount()));
        frame.getTurboOnButton().addActionListener(e ->model.turboOn());
        frame.getTurboOffButton().addActionListener(e -> model.turboOff());
        frame.getLiftBedButton().addActionListener(e -> model.liftBed());
        frame.getLowerBedButton().addActionListener(e ->model.lowerBed());
        frame.getStopButton().addActionListener(e -> model.stopCars());
        frame.getAddVehicleButton().addActionListener(e -> model.addVehicle());
        frame.getRemoveVehicleButton().addActionListener(e -> model.removeVehicle());

    }
    /**
     * updates the view by sending the x and y positions paired with pictures to the view
     */
    @Override
    public void onUpdate() {
        frame.onUpdate(model.createObjectRenderInfos());
    }
//methods:

}
