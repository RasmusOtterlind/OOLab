
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements AnimateListener{
    /**
     * buttons
     */
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
    private ArrayList<JButton> buttonsList = new ArrayList<>();
    CarView frame;
    private CarModel model;
    public CarController(CarModel model) {
        this.model = model;
        buttonsList.add(gasButton);
        buttonsList.add(brakeButton);
        buttonsList.add(turboOnButton);
        buttonsList.add(turboOffButton);
        buttonsList.add(liftBedButton);
        buttonsList.add(lowerBedButton);
        buttonsList.add(addVehicleButton);
        buttonsList.add(removeVehicleButton);
        addActionListeners();
        frame = new CarView("God game x2000",buttonsList);
        addGasSpinner();
        stopButton.setPreferredSize(new Dimension(frame.getWidth()/5-15,200));
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.ORANGE);
        startButton.setPreferredSize(new Dimension(frame.getWidth()/5-15,200));
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        frame.add(startButton);
        frame.add(stopButton);

    }

    /**
     * adds the JSpinner to the frame needed to gas
     */
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
        frame.add(gasPanel);
    }

    /**
     * adds actionListeners to the buttons
     */
    private void addActionListeners(){
        gasButton.addActionListener(e -> model.gas(gasAmount));
        startButton.addActionListener(e -> model.startCars());
        brakeButton.addActionListener(e -> model.brake(gasAmount));
        turboOnButton.addActionListener(e ->model.turboOn());
        turboOffButton.addActionListener(e -> model.turboOff());
        liftBedButton.addActionListener(e -> model.liftBed());
        lowerBedButton.addActionListener(e ->model.lowerBed());
        stopButton.addActionListener(e -> model.stopCars());
        addVehicleButton.addActionListener(e -> model.addVehicle());
        removeVehicleButton.addActionListener(e -> model.removeVehicle());
    }
    /**
     * updates the view by sending the x and y positions paired with pictures to the view
     */
    @Override
    public void onUpdate() {
        frame.onUpdate(model.createObjectRenderInfos());
    }
//methods:

}
