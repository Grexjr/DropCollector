package com.java.DropCatcher.game;

import com.java.DropCatcher.gui.*;
import com.java.DropCatcher.main.Main;
import com.java.DropCatcher.objects.Bucket;
import com.java.DropCatcher.objects.Drop;
import com.java.DropCatcher.util.AudioLoader;
import com.java.DropCatcher.util.SpriteLoader;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

//TODO: Refactor and re-organize
public class DropCatcher {

    private static final Random RAND = new Random();

    private final Container content;
    private final ArrayList<Drop> dropsList;

    private final MainMenuPanel mainMenu;
    private final InstructionsTextPanel instructionsTextPanel;
    private final GameOverPanel gameOverPanel;

    private final DropTimer dropTimer;

    private final Bucket bucket;
    private final ScoreLabel scoreLabel;
    private final HighScoreLabel highScoreLabel;
    private final LifeCounterPanel lifeCounterPanel;

    private int score,highScore,lives;
    private boolean gameOver;
    private boolean gameStarted;

    public DropCatcher(){
        // Basic references
        GameFrame frame = new GameFrame(this);
        content = frame.getContentPane();

        // Initialize the audio loader and Sprite Loader
        AudioLoader.init();
        SpriteLoader.init();

        // Add the bucket
        bucket = new Bucket();
        content.add(bucket);
        initializeBucket();
        content.repaint();

        // Initialize drop list and timer
        dropsList = new ArrayList<>();
        dropTimer = new DropTimer(this);

        // Start the drop timer, starts the game
        dropTimer.getTimer().start();

        // Add the score and high score labels
        scoreLabel = new ScoreLabel();
        highScoreLabel = new HighScoreLabel();
        content.add(scoreLabel);
        content.add(highScoreLabel);
        scoreLabel.setBounds(0,0,scoreLabel.getWidth(),scoreLabel.getHeight());
        highScoreLabel.setBounds(0,scoreLabel.getHeight(),highScoreLabel.getWidth(),highScoreLabel.getHeight());

        // Add the life counter
        lifeCounterPanel = new LifeCounterPanel(this);
        content.add(lifeCounterPanel);
        lifeCounterPanel.setBounds(
                content.getWidth()- lifeCounterPanel.getWidth(),
                0,
                lifeCounterPanel.getWidth(),
                lifeCounterPanel.getHeight()
        );

        // Add the main menu panel
        mainMenu = new MainMenuPanel(this);
        content.add(mainMenu);
        mainMenu.setBounds(
                (content.getWidth()/2) - (mainMenu.getWidth()/3),
                content.getHeight()/2 - (mainMenu.getHeight()/3),
                mainMenu.getWidth(),
                mainMenu.getHeight()
        );

        // Add the instructions text panel
        instructionsTextPanel = new InstructionsTextPanel(this);
        content.add(instructionsTextPanel);
        instructionsTextPanel.setBounds(
                mainMenu.getX(),
                mainMenu.getY(),
                instructionsTextPanel.getWidth(),
                instructionsTextPanel.getHeight()
        );

        // Add the game over panel
        gameOverPanel = new GameOverPanel(this);
        content.add(gameOverPanel);
        gameOverPanel.setBounds(
                0,
                highScoreLabel.getY() + highScoreLabel.getHeight(),
                gameOverPanel.getWidth(),
                gameOverPanel.getHeight());
        gameOverPanel.setVisible(false);

        // Set all components to invisible while main menu panel is up
        bucket.setVisible(false); // TODO: figure out why this isn't disappearing -- probably because repainted by panel
        // Possibility; could just set the background panel to not visible
        scoreLabel.setVisible(false);
        highScoreLabel.setVisible(false);
        lifeCounterPanel.setVisible(false);

        // Start the music
        AudioLoader.playMusic(GameConstants.MUSIC_FILE);

        // Repaint after all components added
        content.repaint();

        // Define game variables
        gameOver = false;
        gameStarted = false;

        score = 0;
        highScore = 0;
        lives = 3;
    }

    public void setGameStarted(boolean value){gameStarted = value;}
    public void setScore(int newScore){score = newScore;}

    public Container getContent(){return content;}
    public MainMenuPanel getMainMenu(){return mainMenu;}
    public ArrayList<Drop> getDropsList(){return dropsList;}
    public Bucket getBucket(){return bucket;}
    public boolean getGameOver(){return gameOver;}
    public boolean getGameStarted(){return gameStarted;}

    private void randomizeDropPosition(Drop drop){
        // Creates drops within the content pane and not too far to the right or too far to the left
        int randX = RAND.nextInt(0, content.getWidth() - drop.getWidth());
        drop.setBounds(randX,0,drop.getWidth(),drop.getHeight());
        drop.repaint();
    }

    public void createDrop(){
        // Only adds drop if less than or equal to 20 drops are on screen
        if(dropsList.size() <= GameConstants.MAX_DROPS) {

            // Create a new drop
            Drop drop = new Drop();

            // Add it to the content pane
            content.add(drop);

            // Add it to the list of all drops
            dropsList.add(drop);

            randomizeDropPosition(drop);
            content.repaint();
        }
    }

    public void moveDropDown(Drop drop){
        int dropX = drop.getX();
        int dropY = drop.getY();

        //System.out.println("Drop Y="+dropY);
        //System.out.println("Content height="+content.getHeight());
        //System.out.println(dropTimer.getDropSpeedMod());

        drop.setBounds(
                dropX,
                dropY + (int)Math.ceil((GameConstants.DROP_SPEED + dropTimer.getDropSpeedMod())),
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
                dropsList.remove(i);
                decreaseLife();
                break;
            }
        }
    }

    private void decreaseLife(){
        if(!(lifeCounterPanel.getLives().size() == 1)){
            lifeCounterPanel.getLives().removeFirst();
            lifeCounterPanel.repaint();
        } else {
            lifeCounterPanel.getLives().removeFirst();
            endGame();
        }
        AudioLoader.playLifeLoss();
    }

    private void initializeBucket(){
        // Sets it to center of screen without having to pass game into bucket
        bucket.setBounds(
                content.getWidth()/2 - bucket.getWidth(),
                content.getHeight()-bucket.getHeight(),
                bucket.getWidth(),
                bucket.getHeight()
        );
        //System.out.println(bucket.getWidth());
    }

    private void runCatchCondition(){
        for(int i = dropsList.size() - 1; i >= 0; i--){

            Rectangle dropRect = dropsList.get(i).getBounds();
            Rectangle bucketRect = bucket.getBounds();

            // Checks if intersect AND 1/4 of bucket; below that will not catch, so not really sideways
            if(bucketRect.intersects(dropRect) &&
                    dropRect.getY() <= (bucketRect.getCenterY() - (double) bucket.getHeight() /4)){
                AudioLoader.playDropSound();
                dropsList.remove(dropsList.get(i));
                score++;
                scoreLabel.updateScore(score);
                if(checkHighScore()){
                    highScoreLabel.updateScore(score);
                }
                //System.out.println("SCORE!" + score);
                break;
            }
        }
    }

    private boolean checkHighScore(){
        return score > highScore;
    }

    public void startGame(){
        gameStarted = true;
        bucket.setVisible(true);
        scoreLabel.setVisible(true);
        highScoreLabel.setVisible(true);
        lifeCounterPanel.setVisible(true);
    }

    private void endGame(){
        gameOver = true;
        gameStarted = false;
        dropsList.removeAll(dropsList);
        content.setIgnoreRepaint(true);

        gameOverPanel.setVisible(true);
    }

    public void showInstructions(){
        mainMenu.setVisible(false);
        instructionsTextPanel.setVisible(true);
        content.repaint();
    }

    public void hideInstructions(){
        instructionsTextPanel.setVisible(false);
        mainMenu.setVisible(true);
        content.repaint();
    }

    public void hideRestart(){
        gameOverPanel.setVisible(false);
    }

    public void restartGame(){
        highScore = score;
        score = 0;
        scoreLabel.updateScore(score);
        lifeCounterPanel.refillLives();
        dropsList.clear();
        content.setIgnoreRepaint(false);

        dropTimer.restartDurationAndSpeed();

        gameOver = false;
        gameStarted = true;
    }


}
