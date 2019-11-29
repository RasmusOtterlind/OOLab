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
    BufferedImage volvoImage;
    BufferedImage saabImage;
    BufferedImage scaniaImage;

    // To keep track of a singel cars position
    ArrayList<ObjectRenderInfo> objectRenderInfos;
    //Point volvoPoint = new Point(1,2);

    // TODO: Make this genereal for all cars
    void moveit(List<Vehicle> vehicles){
        objectRenderInfos = new ArrayList<>();
        for (Vehicle v : vehicles){
            Point p = (new Point((int)Math.round(v.getX()),(int)Math.round(v.getY())));
            BufferedImage image = getVehicleImg(v);
            objectRenderInfos.add(new ObjectRenderInfo(p,image));
        }
    }
    private BufferedImage getVehicleImg(Vehicle vehicle){
        switch (vehicle.getModelName()){
            case "Volvo240":
                return volvoImage;
            case "Saab95":
                return saabImage;
            case "Scania":
                return scaniaImage;

        }


        return null;
    }


    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.BLUE);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            //volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            saabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
            scaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

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
