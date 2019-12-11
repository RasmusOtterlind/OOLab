import model.IFlatBed;
import model.ITurbo;
import model.IVehicle;
import model.VehicleFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.Channel;
import java.util.ArrayList;

public class CarModel {
    private ArrayList<IVehicle> vehicles = new ArrayList<>();
    private ArrayList<AnimateListener> listeners = new ArrayList<>();

    public CarModel(){
        vehicles.add(VehicleFactory.createVolvo240(100,200,0));
    }

    private final int delay = 13;
    private Timer timer = new Timer(delay, new TimerListener());
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle car : vehicles
        ) {
            car.gas(gas);
        }
    }
    public void startCars(){
        for(IVehicle car : vehicles){
            car.startEngine();
        }
    }
    public void brake(int amount){
        double brake = ((double) amount) / 100;
        for (IVehicle car : vehicles){
            car.brake(brake);
        }
    }
    public void turboOn(){
        for(IVehicle vehicle : vehicles) {
            if (vehicle instanceof ITurbo) {
                ((ITurbo)vehicle).setTurboOn();
            }
        }
    }
    public void turboOff(){
        for(IVehicle vehicle : vehicles) {
            if (vehicle instanceof ITurbo) {
                ((ITurbo)vehicle).setTurboOff();
            }
        }
    }
    public void liftBed(){
        for(IVehicle vehicle : vehicles){
            if (vehicle instanceof IFlatBed) {
                ((IFlatBed)vehicle).raiseFlatBed();
            }
        }
    }
    public void lowerBed(){
        for(IVehicle vehicle : vehicles){
            if (vehicle instanceof IFlatBed) {
                ((IFlatBed)vehicle).lowerFlatBed();
            }
        }
    }
    public void stopCars(){
        for(IVehicle vehicle : vehicles){
            vehicle.stopEngine();
        }

    }

    public void changeDirectionIfOut(IVehicle vehicle){
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
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle vehicle : vehicles){
                vehicle.move();
                changeDirectionIfOut(vehicle);
                //int x = (int) Math.round(car.getX());
                //int y = (int) Math.round(car.getY());
                // repaint() calls the paintComponent method of the panel

            }
           notifyListeners();
        }
    }
    public void addListener(AnimateListener listener){
        listeners.add(listener);
    }
    private void  notifyListeners(){
        listeners.forEach(AnimateListener::onUpdate);
    }

}
