import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame {
    private static final int X = 800; //2880 x 1800
    private static final int Y = 800;
    // The controller member
    private DrawPanel drawPanel = new DrawPanel(X, Y-240);
    private JPanel controlPanel = new JPanel();
    public int getX() { return X; }

    // Constructor
    public CarView(String framename, ArrayList<JButton> buttonsList){

        initComponents(framename,buttonsList);
    }


    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title,ArrayList<JButton> buttonsList) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
        controlPanel.setLayout(new GridLayout(2,buttonsList.size()/2));
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        for (int i = 0;i<buttonsList.size();i++){
            controlPanel.add(buttonsList.get(i),i);
        }
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);
        // TODO: Create more for each component as necessary
        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void onUpdate(ArrayList<ObjectRenderInfo> objectRenderInfos) {
        drawPanel.moveIt(objectRenderInfos);
        repaint();
    }
}