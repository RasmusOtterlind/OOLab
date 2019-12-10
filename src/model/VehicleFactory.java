package model;

        /**A factory to create different vehicles to make our code have less dependencies
         *
         */
public class  VehicleFactory {
    public static IVehicle createSabb95(double x, double y, double direction){ return new Saab95(x,y,direction); }

    public static IVehicle createVolvo240(double x, double y, double direction){ return new Volvo240(x,y,direction); }

    public static IVehicle createScaniaTruck(double x, double y, double direction){ return new ScaniaTruck(x,y,direction); }

    public static IVehicle createTransportTruck(double x, double y, double direction){ return new TransportTruck(x,y,direction); }
}
