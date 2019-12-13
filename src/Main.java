import Controller.CarController;
import model.CarModel;

/**
 * the main application
 */
public class Main{
    public static void main(String[] args){
        CarModel carModel = new CarModel();
        CarController carController = new CarController(carModel);
        carModel.addListener(carController);
    }

}