package newobjects.abstracta;

import com.java.DropCatcher.util.SpriteLoader;
import newobjects.ObjectConstants;

import javax.swing.*;
import java.awt.image.BufferedImage;

public abstract class AbstractObject extends JComponent {

    private final BufferedImage sprite;
    private final double scale;

    private int absX,absY;


    public AbstractObject(BufferedImage sprite){
        this.sprite = sprite;
        absX = 0;
        absY = 0;
        scale = ObjectConstants.OBJECT_SCALE_FACTOR;
    }

    public BufferedImage getSprite() {
        return sprite;
    }

    public int getAbsX() {
        return absX;
    }

    public void setAbsX(int absX) {
        this.absX = absX;
    }

    public int getAbsY() {
        return absY;
    }

    public void setAbsY(int absY) {
        this.absY = absY;
    }

    public double getScale() {
        return scale;
    }
}
