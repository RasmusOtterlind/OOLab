package View;

import model.ObjectRenderInfo;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class CarSpeedFrame extends JFrame {
    private static int x = 250;
    private static int y = 400;
    private ArrayList<JButton> speedButtons = new ArrayList<>();
    public CarSpeedFrame(){
        this.setTitle("Car Speed");
        this.setPreferredSize(new Dimension(x, y));
        this.pack();
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
        this.setVisible(true);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width-this.getSize().width, dim.height/2-this.getSize().height/2);
    }
    public void createLabelsAndAdd(ArrayList<ObjectRenderInfo> objectRenderInfos){
        removeOldButtons();
        for (ObjectRenderInfo objectRenderInfo: objectRenderInfos){
            JButton button = new JButton(objectRenderInfo.getName()+" speed: "+(int)objectRenderInfo.getSpeed()*8);
            this.add(button);
            speedButtons.add(button);
        }
        this.pack();
        this.repaint();
    }
    private void removeOldButtons(){
        for (JButton button : speedButtons){
            this.remove(button);
        }
        speedButtons.clear();
    }


}
