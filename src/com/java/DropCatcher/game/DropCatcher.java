package com.java.DropCatcher.game;

import com.java.DropCatcher.gui.GameFrame;
import com.java.DropCatcher.objects.Bucket;
import com.java.DropCatcher.objects.Drop;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class DropCatcher {

    private static final Random RAND = new Random();

    private final Container content;
    private final ArrayList<Drop> dropsList;

    private final DropTimer dropTimer;
    private final Bucket bucket;

    private int score,highScore,lives;
    private boolean gameOver;
    private boolean gameStarted;

    public DropCatcher(){
        GameFrame frame = new GameFrame(this);
        content = frame.getContentPane();

        // Add the bucket
        bucket = new Bucket();
        content.add(bucket);
        initializeBucket();
        content.repaint();

        dropsList = new ArrayList<>();
        dropTimer = new DropTimer(this);

        dropTimer.getTimer().start();
        content.repaint();

        // Define game variables
        gameOver = false;
        gameStarted = false;

        score = 0;
        highScore = 0;
        lives = 3;
    }

    public Container getContent(){return content;}
    public ArrayList<Drop> getDropsList(){return dropsList;}
    public Bucket getBucket(){return bucket;}

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

        //System.out.println("Drop Y="+dropY);
        //System.out.println("Content height="+content.getHeight());

        drop.setBounds(
                dropX,
                dropY + GameConstants.DROP_SPEED,
                drop.getWidth(),
                drop.getHeight());
        drop.repaint();

        runCatchCondition();

        removeDrops();
    }

    private void removeDrops(){
        // Need to decrement through array list because causes issues if you go forward through the arraylist
        for(int i = dropsList.size() - 1; i >= 0; i--){
            if(dropsList.get(i).getY() >= content.getHeight()){
                //System.out.println("Drop Height at removal=" + dropsList.get(i).getY());
                //System.out.println("Drop list size:"+dropsList.size());
                dropsList.remove(i);
            }
        }
    }

    private void initializeBucket(){
        // Sets it to center of screen without having to pass game into bucket
        bucket.setBounds(
                content.getWidth()/2 - bucket.getWidth(),
                content.getHeight()-bucket.getHeight(),
                bucket.getWidth(),
                bucket.getHeight()
        );
        System.out.println(bucket.getWidth());
    }

    private void runCatchCondition(){
        for(int i = dropsList.size() - 1; i >= 0; i--){

            Rectangle dropRect = dropsList.get(i).getBounds();
            Rectangle bucketRect = bucket.getBounds();

            if(bucketRect.intersects(dropRect)){
                dropsList.remove(dropsList.get(i));
                score++;
                System.out.println("SCORE!" + score);
            }
        }
    }


}
