import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarSpeedLabel extends JFrame {
    private static int x = 400;
    private static int y = 400;
    private JLabel jLabel = new JLabel("CarSpeeds");


    public CarSpeedLabel(){
        this.setPreferredSize(new Dimension(400, 400));
        this.setTitle("CarSpeeds");
        jLabel.setLayout(new GridLayout(3,5));
        jLabel.add(new JButton("hallå"));
        this.add(jLabel);
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setVisible(true);
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        jLabel.setSize(dim);
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.repaint();

    }




    public void updateSpeed(ArrayList<String> list){
        StringBuilder sb = new StringBuilder();
        for (String string: list){
            sb.append(string);
        }
    }
}
