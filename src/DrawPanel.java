import model.IVehicle;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    //ArrayList<BufferedImage> images = new ArrayList<>();
    // To keep track of a snigel cars position
    private ArrayList<ObjectRenderInfo>  objectRenderInfos = new ArrayList<>();
    //Point volvoPoint = new Point(1,2);
    // TODO: Make this genereal for all cars
    void moveIt(ArrayList<ObjectRenderInfo> vehicles){
        objectRenderInfos = vehicles;
    }
    // Initializes the panel and reads the images
    DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.PINK);
        // Print an error message in case file is not found with a try/catch block
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        for(ObjectRenderInfo object : objectRenderInfos){
            g.drawImage(object.getImage(),object.getPoint().x,object.getPoint().y,null);
        }
        //g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null); // see javadoc for more info on the parameters
    }
}
