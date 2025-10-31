package newcontroller;

import newgui.*;
import newobjects.abstracta.AbstractObject;

import java.awt.*;

public class GUIManager {

    private final DropCatcher game;
    private final GameFrame frame;
    private final MenuScreen menu;
    private final InstructionsPanel instructions;
    private final SettingsPanel settings;
    private final CreditsPanel credits;

    // Screens
    private final GameScreen gameScreen;

    public GUIManager(){
        // Initialize
        game = new DropCatcher(this);
        frame = new GameFrame();
        menu = new MenuScreen(this);
        instructions = new InstructionsPanel(this);
        settings = new SettingsPanel(this);
        credits = new CreditsPanel(this);

        gameScreen = new GameScreen(game);
        onStartup();
    }

    public Container getContent(){
        return frame.getContentPane();
    }

    private void onStartup(){
        frame.setVisible(true);
        frame.swapScreen(menu);
    }

    public void startGame(){
        //DEBUG
        System.out.println(game.getClass().getSimpleName() + "=started;");
        frame.swapScreen(gameScreen);
        game.startLoop();
    }

    public void showInstructions(){
        frame.swapScreen(instructions);
    }

    public void hideInstructions(){
        frame.swapScreen(menu);
    }

    public void showSettings(){
        //DEBUG
        System.out.println(settings.getClass().getSimpleName()+"=shown;");
        frame.swapScreen(settings);
    }

    public void hideSettings(){
        //DEBUG
        System.out.println(settings.getClass().getSimpleName()+"hidden;");
        frame.swapScreen(menu);
    }

    public void showCredits(){
        //DEBUG
        System.out.println(credits.getClass().getSimpleName()+"=shown;");
        frame.swapScreen(credits);
    }

    public void hideCredits(){
        //DEBUG
        System.out.println(credits.getClass().getSimpleName()+"=hidden;");
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


}
