package model;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Class used to render cars on the map
 */
public class ObjectRenderInfo {
    private Point point;
    private double speed;
    private String name;
    public ObjectRenderInfo(Point point,double speed,String name){
        this.point = point;
        this.speed = speed;
        this.name = name;
    }

    public Point getPoint() {
        return point;
    }

    public double getSpeed() { return speed; }

    public String getName(){ return name; }
}
