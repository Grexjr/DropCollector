package com.java.DropCatcher.objects;

import com.java.DropCatcher.util.SpriteLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

// NOTE: Setting bounds in this class sets it relative to the JComponent, not to the parent component.
public class Drop extends JComponent {

    // A single variable to ensure only one sprite object image is actually loaded, rather than every repaint
    private static final BufferedImage SPRITE = SpriteLoader.loadSprite("DropBlurred.png");

    private final int width,height;
    private int xPos,yPos;

    public Drop(){
        xPos = 0;
        yPos = 0;
        width = ObjectConstants.DROP_WIDTH;
        height = ObjectConstants.DROP_HEIGHT;

        setBounds(xPos,yPos,width,height);
    }

    public BufferedImage getSprite(){return SPRITE;}

    /*
     * REMOVED THE PAINT METHOD IN THIS CLASS
     * Now handled by the background panel which contains these objects to paint them as it is constantly repainted.
     * */

}
