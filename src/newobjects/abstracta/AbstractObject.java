package newobjects.abstracta;

import com.java.DropCatcher.util.SpriteLoader;
import newobjects.GameWorld;
import newobjects.ObjectConstants;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public abstract class AbstractObject extends JComponent {

    private final BufferedImage sprite;

    private int absX,absY,absWidth,absHeight;
    private Rectangle2D rectangle;

    public AbstractObject(BufferedImage sprite){
        this.sprite = sprite;
        absX = 0;
        absY = 0;
        absWidth = 0;
        absHeight = 0;
        rectangle = new Rectangle(absX,absY,absWidth,absHeight);
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

    public int getAbsWidth() {
        return absWidth;
    }

    public void setAbsWidth(int absWidth) {
        this.absWidth = absWidth;
    }

    public int getAbsHeight() {
        return absHeight;
    }

    public void setAbsHeight(int absHeight) {
        this.absHeight = absHeight;
    }

    public Rectangle2D getRectangle() {
        return rectangle;
    }

    public void setRectangle(Rectangle2D rectangle) {
        this.rectangle = rectangle;
    }

    // All objects must exist inside the game world
    public abstract void init(GameWorld world); // Overridden by subclasses to set basic things (can probably move sprite in here)
}
