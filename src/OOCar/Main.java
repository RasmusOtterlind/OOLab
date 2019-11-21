package OOCar;

import java.awt.*;

public class Main{
    public static void main(String[] args){
        System.out.println("hello world");
        Storage<Vehicle> v = new Storage<>(10, Storage.UnloadOrder.lastInFirstOut);
        v.addToStorage(new Saab95());
        v.addToStorage(new Volvo240());

    }

}