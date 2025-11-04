package newcontroller;

import com.java.DropCatcher.gui.MainMenuPanel;
import newgui.*;
import newgui.abstracta.AbstractScreen;
import newobjects.abstracta.AbstractObject;

import java.awt.*;

public class GUIManager {

    private final DropCatcher game;
    private final GameFrame frame;

    private MenuScreen menu;
    private InstructionsPanel instructions;
    private SettingsPanel settings;
    private CreditsPanel credits;

    // Screens
    private GameScreen gameScreen;
    private GameOverPanel gameOver;

    public GUIManager(){
        // Initialize
        game = new DropCatcher(this);
        frame = new GameFrame();

        onStartup();
    }

    public Container getContent(){
        return frame.getContentPane();
    }

    public void changeScreen(AbstractScreen last, AbstractScreen current){
        last.dispose();
        frame.swapScreen(current);
    }

    private void onStartup(){
        frame.setVisible(true);
        menu = new MenuScreen(this);
        frame.swapScreen(menu);
    }

    public void startGame(){
        //DEBUG
        System.out.println(game.getClass().getSimpleName() + "=started;");
        gameScreen = new GameScreen(game);
        changeScreen(menu,gameScreen);
        game.startLoop();
    }

    public void showInstructions(){
        instructions = new InstructionsPanel(this);
        frame.swapScreen(instructions);
    }

    public void hideInstructions(){
        instructions = null; // DISPOSE: TODO: make centralized method for this
        frame.swapScreen(menu);
    }

    public void showSettings(){
        //DEBUG
        settings = new SettingsPanel(this);
        System.out.println(settings.getClass().getSimpleName()+"=shown;");
        frame.swapScreen(settings);
    }

    public void hideSettings(){
        //DEBUG
        System.out.println(settings.getClass().getSimpleName()+"hidden;");
        settings = null;
        frame.swapScreen(menu);
    }

    public void showCredits(){
        //DEBUG
        credits = new CreditsPanel(this);
        System.out.println(credits.getClass().getSimpleName()+"=shown;");
        frame.swapScreen(credits);
    }

    public void hideCredits(){
        //DEBUG
        System.out.println(credits.getClass().getSimpleName()+"=hidden;");
        credits = null;
        frame.swapScreen(menu);
    }

    double calculateScaleRatioX(){
        return (double)(getContent().getWidth())/game.getObjects().getWorld().getWidth();
    }

    double calculateScaleRatioY(){
        return (double) (getContent().getHeight())/(game.getObjects().getWorld().getHeight());
    }

    // Game Screen methods
    public boolean runGameInput(){
        return gameScreen.getPressed();
    }

    public int getClickX(){
        return gameScreen.getMouseX();
    }

    public void updateScoreLabel(int score){
        gameScreen.getScoreLabel().updateScore(score);
    }

    public void updateHighScoreLabel(int score){
        gameScreen.getHighScoreLabel().updateHighScore(score);
    }

    public void runGameOver(){
        updateHighScoreLabel(game.getHighScore());
        gameOver = new GameOverPanel(this);
        frame.swapScreen(gameOver);
    }

    // Game over methods
    public void restartGame(){
        gameScreen = new GameScreen(game);
        menu = new MenuScreen(this); //Not ideal but because my gui code is messed the F*** up
        gameOver = null;
        startGame();
    }

    public void returnToMenu(){
        menu = new MenuScreen(this);
        changeScreen(gameScreen,menu);
        gameOver = null;
    }


}
