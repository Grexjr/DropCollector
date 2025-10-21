package com.java.DropCatcher.objects;

import com.java.DropCatcher.game.DropCatcher;
import com.java.DropCatcher.util.SpriteLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class LifeCount extends JComponent {

    private static final BufferedImage SPRITE = SpriteLoader.loadSprite("HeartSprite.png");

    private final int xPos,yPos,width,height;

    public LifeCount(){
        // Define the base values for the heart sprite
        xPos = 0;
        yPos = 0;
        width = ObjectConstants.HEART_WIDTH;
        height = ObjectConstants.HEART_HEIGHT;

        setBounds(xPos,yPos,width,height);
    }

    public BufferedImage getSprite(){return SPRITE;}

}
