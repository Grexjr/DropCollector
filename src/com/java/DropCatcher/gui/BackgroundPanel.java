package com.java.DropCatcher.gui;

import com.java.DropCatcher.game.DropCatcher;
import com.java.DropCatcher.objects.Bucket;
import com.java.DropCatcher.objects.Drop;
import com.java.DropCatcher.util.SpriteLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BackgroundPanel extends JPanel {

    private final DropCatcher dropCatch;

    private BufferedImage bgImage;

    public BackgroundPanel(DropCatcher game){
        dropCatch = game;
        bgImage = SpriteLoader.loadSprite("BeautifulBackGround.png");
        setLayout(null);
        setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        if(bgImage != null){
            g.drawImage(bgImage,0,0,getWidth(),getHeight(),null);
        }

        if(dropCatch.getDropsList() != null){
            for (Drop d : dropCatch.getDropsList()) {
                g.drawImage(d.getSprite(), d.getX(), d.getY(), d.getWidth(), d.getHeight(), null);
            }
        }

        Bucket bucket = dropCatch.getBucket();

        if(dropCatch.getBucket() != null){
            g.drawImage(bucket.getSprite(), bucket.getX(), bucket.getY(), bucket.getWidth(), bucket.getHeight(), null);
        }
    }



}
