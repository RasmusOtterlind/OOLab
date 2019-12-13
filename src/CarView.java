import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame{
    private static final int X = 800; //2880 x 1800
    private static final int Y = 800;
    // The controller member
    private JSpinner gasSpinner = new JSpinner();
    private JPanel gasPanel = new JPanel();
    private int gasAmount = 0;
    private JLabel gasLabel = new JLabel("Amount of gas");
    private JButton gasButton = new JButton("Gas");
    private JButton brakeButton = new JButton("Brake");
    private JButton turboOnButton = new JButton("Saab Turbo on");
    private JButton turboOffButton = new JButton("Saab Turbo off");
    private JButton liftBedButton = new JButton("Lift Bed");
    private JButton lowerBedButton = new JButton("Lower Bed");
    private JButton startButton = new JButton("Start all cars");
    private JButton stopButton = new JButton("Stop all cars");
    private JButton addVehicleButton = new JButton("Add a random vehicle");
    private JButton removeVehicleButton = new JButton("Remove last added vehicle");
    private CarSpeedLabel carSpeedLabel = new CarSpeedLabel();
    private DrawPanel drawPanel = new DrawPanel(X, Y-240);
    private JPanel controlPanel = new JPanel();
    public int getGasAmount(){return gasAmount; }
    public int getX() { return X; }

    public JButton getGasButton() {
        return gasButton;
    }

    public JButton getBrakeButton() {
        return brakeButton;
    }

    public JButton getTurboOnButton() {
        return turboOnButton;
    }

    public JButton getTurboOffButton() {
        return turboOffButton;
    }

    public JButton getLiftBedButton() {
        return liftBedButton;
    }

    public JButton getLowerBedButton() {
        return lowerBedButton;
    }

    public JButton getStartButton() {
        return startButton;
    }

    public JButton getStopButton() {
        return stopButton;
    }

    public JButton getAddVehicleButton() {
        return addVehicleButton;
    }

    public JButton getRemoveVehicleButton() {
        return removeVehicleButton;
    }

    // Constructor
    public CarView(String framename){
        stopButton.setPreferredSize(new Dimension(this.getWidth()/5-15,200));
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.ORANGE);
        startButton.setPreferredSize(new Dimension(this.getWidth()/5-15,200));
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        initComponents(framename);
        addGasSpinner();
    }


    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {
        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.add(drawPanel);
        controlPanel.setLayout(new GridLayout(2,5));
        controlPanel.setPreferredSize(new Dimension((X), 200));
        controlPanel.add(gasButton);
        controlPanel.add(brakeButton);
        controlPanel.add(liftBedButton);
        controlPanel.add(lowerBedButton);
        controlPanel.add(turboOnButton);
        controlPanel.add(turboOffButton);
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(addVehicleButton);
        controlPanel.add(removeVehicleButton);
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
    private void addGasSpinner(){SpinnerModel spinnerModel =
            new SpinnerNumberModel(0, //initial value
                    0, //min
                    100, //max
                    1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }});

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);
    }


    public void onUpdate(ArrayList<ObjectRenderInfo> objectRenderInfos) {
        drawPanel.moveIt(objectRenderInfos);
        repaint();
    }
}