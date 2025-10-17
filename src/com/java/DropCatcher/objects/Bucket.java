package com.java.DropCatcher.objects;

import com.java.DropCatcher.game.DropCatcher;
import com.java.DropCatcher.util.SpriteLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Bucket extends JComponent {

    private static final BufferedImage SPRITE = SpriteLoader.loadSprite("Bucket.png");

    private int xPos,yPos;
    private int width,height;

    public Bucket(){
        width = ObjectConstants.BUCKET_WIDTH;
        height = ObjectConstants.BUCKET_HEIGHT;
        xPos = 0;
        yPos = 0;

        setBounds(xPos,yPos,width,height);

        setVisible(true);
    }

    public BufferedImage getSprite(){return SPRITE;}


    /*
    * REMOVED THE PAINT METHOD IN THIS CLASS
    * Now handled by the background panel which contains these objects to paint them as it is constantly repainted.
    * */


}
