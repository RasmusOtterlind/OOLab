package model;

import Controller.AnimateListener;
import View.ObjectRenderInfo;
import model.IFlatBed;
import model.ITurbo;
import model.IVehicle;
import model.VehicleFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarModel {
    private ArrayList<IVehicle> vehicles = new ArrayList<>();
    private ArrayList<AnimateListener> listeners = new ArrayList<>();
    private final int delay = 13;
    private Timer timer = new Timer(delay, new TimerListener());


    public CarModel(){

        timer.start();
    }


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
    public void addVehicle(){
        double rand = Math.random()*10;
        if(!(vehicles.size()>=9)) {
            if (rand >= 0 && rand < 4) {
                vehicles.add(VehicleFactory.createVolvo240(100, vehicles.size() * 60 + 1, 0));
            } else if (rand >= 4 && rand <= 7) {
                vehicles.add(VehicleFactory.createScaniaTruck(100, vehicles.size() * 60 + 1, 0));
            } else {
                vehicles.add(VehicleFactory.createSaab95(100, vehicles.size() * 60 + 1, 0));
            }
        }
    }
    public void removeVehicle(){
        if(!vehicles.isEmpty()){
            vehicles.remove(vehicles.size()-1);
        }
    }
    private boolean checkIfOut(IVehicle entity){
        if((entity.getX()<=0|| entity.getX()>=700) || entity.getY()<=0 || entity.getY()>=500){
            return true;
        }
        return false;
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle vehicle : vehicles){
                vehicle.move();
                changeDirectionIfOut(vehicle);
            }
           notifyListeners();
        }
    }
    public ArrayList<ObjectRenderInfo> createObjectRenderInfos(){
        ArrayList<ObjectRenderInfo> objectRenderInfos = new ArrayList<>();
        for (IVehicle vehicle : vehicles){
            Point p = new Point((int)vehicle.getX(),(int)vehicle.getY());
            objectRenderInfos.add(new ObjectRenderInfo(p,vehicle.getCurrentSpeed(),vehicle.getModelName()));
        }
        return objectRenderInfos;
    }

    public void addListener(AnimateListener listener){
        listeners.add(listener);
    }
    private void  notifyListeners(){
        for (AnimateListener listener: listeners){
            listener.onUpdate();
        }
    }

}
