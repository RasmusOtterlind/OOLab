import java.awt.*;
import java.awt.image.BufferedImage;

public class ObjectRenderInfo {
    private Point point;
    private BufferedImage image;
    public ObjectRenderInfo(Point point,BufferedImage image){
        this.point = point;
        this.image = image;
    }

    public Point getPoint() {
        return point;
    }

    public BufferedImage getImage() {
        return image;
    }
}
