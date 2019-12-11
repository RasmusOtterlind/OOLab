import java.awt.*;

/**
 * ignore this
 */
public class Main{
    public static void main(String[] args){
        CarModel carModel = new CarModel();
        CarController carController = new CarController(carModel);
        carModel.addListener(carController.frame);
    }

}