package com.java.DropCatcher.game;

import com.java.DropCatcher.gui.GameFrame;
import com.java.DropCatcher.objects.Drop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DropCatcher {

    private static final Random RAND = new Random();

    private final GameFrame frame;
    private final Container content;
    private final ArrayList<Drop> dropsList;

    private DropTimer dropTimer;

    private boolean gameOver;
    private boolean gameStarted;

    public DropCatcher(){
        frame = new GameFrame();
        content = frame.getContentPane();
        dropsList = new ArrayList<>();
        dropTimer = new DropTimer(this);

        gameOver = false;
        gameStarted = false;

        dropTimer.getTimer().start();
    }

    public Container getContent(){return content;}
    public ArrayList<Drop> getDropsList(){return dropsList;}

    private void randomizeDropPosition(Drop drop){
        int randX = RAND.nextInt(0, content.getWidth());
        drop.setBounds(randX,0,drop.getWidth(),drop.getHeight());
        drop.repaint();
    }

    public Drop createDrop(){
        // Create a new drop
        Drop drop = new Drop();

        // Add it to the content pane
        content.add(drop);

        // Add it to the list of all drops
        dropsList.add(drop);

        randomizeDropPosition(drop);
        content.repaint();

        return drop;
    }

    public void moveDropDown(Drop drop){
        int dropX = drop.getX();
        int dropY = drop.getY();

        drop.setBounds(
                dropX,
                dropY + GameConstants.DROP_SPEED,
                drop.getWidth(),
                drop.getHeight());
        drop.repaint();
    }


}
