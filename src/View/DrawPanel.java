package View;


import model.ObjectRenderInfo;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{



    private ArrayList<ObjectRenderInfo>  objectRenderInfos = new ArrayList<>();
    private BufferedImage volvoImage;
    private BufferedImage saabImage;
    private BufferedImage scaniaImage;
    // TODO: Make this genereal for all cars
    void moveIt(ArrayList<ObjectRenderInfo> vehicles){
        objectRenderInfos = vehicles;
    }
    // Initializes the panel and reads the images
    DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.PINK);
        try {
            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
        // Print an error message in case file is not found with a try/catch block
    }
    private BufferedImage getVehicleImg(String name){
        switch (name){
            case "Volvo240":
                return volvoImage;
            case "Saab95":
                return saabImage;
            case "Scania":
                return scaniaImage;
        }
        return null;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent (Graphics g) {
        super.paintComponent(g);
        for(ObjectRenderInfo object : objectRenderInfos){
            g.drawImage(getVehicleImg(object.getName()),object.getPoint().x,object.getPoint().y,null);
        }
    }
}
