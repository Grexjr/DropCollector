package com.java.DropCatcher.gui;

import com.java.DropCatcher.util.SpriteLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BackgroundPanel extends JPanel {

    private BufferedImage bgImage;

    public BackgroundPanel(){
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
    }



}
