package newcontroller;

import newobjects.Droplet;
import newobjects.abstracta.AbstractObject;

import java.awt.*;

public class DropCatcher {

    private final GUIManager gui;
    private final ObjectManager objects;
    private final GameLoop loop;

    private int dropDelay,dropTimer,dropSpeed,score,highScore;
    private double speedMod,rawDelay;


    //TODO: add db mode that draws object rectangles etc.

    public DropCatcher(GUIManager gui){
        this.gui = gui;
        objects = new ObjectManager();
        loop = new GameLoop(this);

        dropDelay = GameConstants.INITIAL_DELAY;
        rawDelay = dropDelay;
        dropTimer = 0;
        score = 0;
        highScore = score;
        speedMod = GameConstants.INITIAL_SPEED_MOD;
        dropSpeed = GameConstants.BASE_DROP_SPEED;
    }

    public ObjectManager getObjects(){
        return objects;
    }

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
        loop.start();
    }

    /// MAIN GAME LOOP - EXECUTES EVERY FRAME
    public void update(){
        // Repaint content pane every frame
        gui.getContent().repaint();

        // Run player input
        runPlayerInput();

        // Move the droplets down
        runDroplets();

        // Create a droplet if the timer has gone above the delay
        createDroplets();

        dropTimer++;
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
                }
            }
            // Run the removal if drop goes below world and there are droplets left and lose life
            if(!objects.getDroplets().isEmpty()){
                if (objects.getDroplets().get(i).getAbsY() >= objects.getWorld().getHeight()) {
                    objects.getDroplets().remove(i);
                    //TODO: Lose life
                    //DEBUG
                    System.out.println("DropNum: " + objects.getDroplets().size());
                }
            }
        }
    }

    //TODO: Change this to a better system not based on maximum droplets being reached, but game time
    private void createDroplets(){
        if(dropTimer >= dropDelay){
            dropTimer = 0;
            objects.createDroplet();
            //DEBUG
            System.out.println("Delay="+dropDelay);
            if(dropDelay > GameConstants.MINIMUM_DELAY){
                rawDelay = rawDelay - GameConstants.DELAY_DECREASE;
                dropDelay = Math.toIntExact(Math.round(rawDelay));
            }
            //DEBUG
            System.out.println("DropSpeed="+dropSpeed*speedMod);
            System.out.println("DropSpeedMod="+speedMod);
            if((dropSpeed * speedMod) < GameConstants.MAX_SPEED){
                speedMod += GameConstants.SPEED_MOD_INCREASE;
            }
        }
    }






}
