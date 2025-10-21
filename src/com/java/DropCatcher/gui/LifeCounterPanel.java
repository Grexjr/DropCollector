package com.java.DropCatcher.gui;

import com.java.DropCatcher.game.DropCatcher;
import com.java.DropCatcher.objects.LifeCount;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class LifeCounterPanel extends JPanel {

    private static final int MAX_LIVES = 3;
    private static final int OFFSET = 100;

    private final DropCatcher dropCatch;
    private final ArrayList<LifeCount> heartCounter;

    public LifeCounterPanel(DropCatcher game){
        dropCatch = game;

        setLayout(null);

        setBounds(0,0,GUIConstants.HEART_COUNTER_SIZE[0],GUIConstants.HEART_COUNTER_SIZE[1]);

        // Fully transparent background
        setBackground(new Color(255,255,255,0));

        heartCounter = new ArrayList<>();
        for(int i = 0; i < MAX_LIVES; i++){
            LifeCount heart = new LifeCount();
            heartCounter.add(heart);
            add(heart);
        }

        setVisible(true);
    }

    public ArrayList<LifeCount> getLives(){return heartCounter;}

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(int i = 0; i < heartCounter.size(); i++){
            LifeCount heart = heartCounter.get(i);
            int offset = i * OFFSET;
            g.drawImage(
                    heart.getSprite(),
                    this.getWidth() - heart.getWidth() - (heart.getX() + offset),
                    heart.getY(),
                    heart.getWidth(),
                    heart.getHeight(),
                    null);
        }



    }

    public void refillLives(){
        for(int i = 0; i < MAX_LIVES; i++){
            LifeCount heart = new LifeCount();
            heartCounter.add(heart);
            add(heart);
        }
    }












}
