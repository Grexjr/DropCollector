package com.java.DropCatcher.objects;

import com.java.DropCatcher.util.SpriteLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

// NOTE: Setting bounds in this class sets it relative to the JComponent, not to the parent component.
public class Drop extends JComponent {

    private final int width,height;
    private int xPos,yPos;

    public Drop(){
        xPos = 0;
        yPos = 0;
        width = ObjectConstants.DROP_WIDTH;
        height = ObjectConstants.DROP_HEIGHT;

        setBounds(xPos,yPos,width,height);

        setVisible(true);
    }

    @Override
    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        BufferedImage sprite = SpriteLoader.loadSprite("DropBlurred.png");

        if(sprite != null){
            g2.drawImage(sprite,xPos,yPos,width,height,null);
        }
    }




}
