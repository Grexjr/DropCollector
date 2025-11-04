package com.java.DropCatcher.newcontroller;

import com.java.DropCatcher.util.AudioLoader;
import com.java.DropCatcher.util.SpriteLoader;
import com.java.DropCatcher.newobjects.abstracta.AbstractObject;

import java.awt.*;

public class DropCatcher {

    private final GUIManager gui;
    private final ObjectManager objects;
    private final GameLoop loop;

    private int dropDelay,dropTimer,dropSpeed,score,highScore;
    private double speedMod,rawDelay;
    private boolean gameOver;

    //TODO: add db mode that draws object rectangles etc.

    public DropCatcher(GUIManager gui){
        this.gui = gui;
        objects = new ObjectManager();
        loop = new GameLoop(this);
        // Initialize the audio loader and Sprite Loader
        AudioLoader.init();
        SpriteLoader.init();

        dropDelay = GameConstants.INITIAL_DELAY;
        rawDelay = dropDelay;
        dropTimer = 0;
        score = 0;
        highScore = score;
        speedMod = GameConstants.INITIAL_SPEED_MOD;
        dropSpeed = GameConstants.BASE_DROP_SPEED;
        gameOver = false;
    }

    public ObjectManager getObjects(){
        return objects;
    }
    public int getScore(){return score;}
    public int getHighScore(){return highScore;}

    public int calculateScreenXPos(AbstractObject object){
        return (int)(object.getAbsX() * gui.calculateScaleRatioX());
    }

    public int calculateScreenYPos(AbstractObject object){
        return (int)(object.getAbsY() * gui.calculateScaleRatioY());
    }

    public int calculateScreenDimension(int absoluteDimension){
        double scale = Math.min(gui.calculateScaleRatioX(),gui.calculateScaleRatioY());
        return (int)(absoluteDimension * scale);
    }

    public void startLoop(){
        gameOver = false;
        loop.start();
    }

    /// MAIN GAME LOOP - EXECUTES EVERY FRAME
    public void update(){
        if(!gameOver){// Repaint content pane every frame
            gui.getContent().repaint();

            // Run player input
            runPlayerInput();

            // Move the droplets down
            runDroplets();

            // Create a droplet if the timer has gone above the delay
            createDroplets();

            dropTimer++;
        }
    }

    private void runPlayerInput(){
        if(gui.runGameInput()){
            objects.getBucket().moveBucket(
                    (int)(gui.getClickX()/gui.calculateScaleRatioX()
                            - (double) objects.getBucket().getAbsWidth() /2)
            );
            if((objects.getBucket().getAbsX() + objects.getBucket().getAbsWidth()) > objects.getWorld().getWidth()){
                objects.getBucket().moveBucket(objects.getWorld().getWidth() - objects.getBucket().getAbsWidth());
            }
            if(objects.getBucket().getAbsX() < 0){
                objects.getBucket().moveBucket(0);
            }
        }
    }

    private void runDroplets(){
        for(int i = objects.getDroplets().size()-1; i >= 0; i--){

            // Check to make sure there are droplets
            if(!objects.getDroplets().isEmpty()){
                objects.getDroplets().get(i).moveDroplet(dropSpeed,speedMod);
            }

            // Run collision check if there are droplets
            if(!objects.getDroplets().isEmpty()){
                if (objects.getDroplets().get(i).checkDropCollision((Rectangle) objects.getBucket().getRectangle())) {
                    objects.getDroplets().remove(i);
                    score++;
                    if(score > highScore){
                        highScore = score;
                        gui.updateHighScoreLabel(highScore);
                    }
                    gui.updateScoreLabel(score);
                    AudioLoader.playDropSound();
                }
            }

            // Run the removal if drop goes below world and there are droplets left and lose life
            if(!objects.getDroplets().isEmpty()){
                if (objects.getDroplets().get(i).getAbsY() >= objects.getWorld().getHeight()) {
                    objects.getDroplets().remove(i);
                    loseLife();
                    //DEBUG
                    //System.out.println("DropNum: " + objects.getDroplets().size());
                }
            }
        }
    }

    private void loseLife(){
        if(!(getObjects().getLives().size() == 1)){
            getObjects().getLives().removeLast();
        } else {
            getObjects().getLives().removeLast();
            runGameOver();
        }
        AudioLoader.playLifeLoss();
    }

    private void runGameOver(){
        loop.stop();
        resetValues();
        gui.runGameOver();
        gameOver = true;
    }

    private void resetValues(){
        objects.initializeLives();
        objects.getDroplets().clear();
        dropDelay = GameConstants.INITIAL_DELAY;
        rawDelay = dropDelay;
        speedMod = GameConstants.INITIAL_SPEED_MOD;
        score = 0;
    }

    private void createDroplets(){
        if(dropTimer >= dropDelay){
            dropTimer = 0;
            objects.createDroplet();
            //DEBUG
            //System.out.println("Delay="+dropDelay);
            if(dropDelay > GameConstants.MINIMUM_DELAY){
                rawDelay = rawDelay - GameConstants.DELAY_DECREASE;
                dropDelay = Math.toIntExact(Math.round(rawDelay));
            }
            //DEBUG
            //System.out.println("DropSpeed="+dropSpeed*speedMod);
            //System.out.println("DropSpeedMod="+speedMod);
            if((dropSpeed * speedMod) < GameConstants.MAX_SPEED){
                speedMod += GameConstants.SPEED_MOD_INCREASE;
            }
        }
    }






}
