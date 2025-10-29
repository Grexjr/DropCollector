package newcontroller;

import newgui.*;

public class GUIManager {

    private final DropCatcher game;
    private final GameFrame frame;
    private final MenuScreen menu;
    private final InstructionsPanel instructions;
    private final CreditsPanel credits;

    // Screens
    private final GameScreen gameScreen;

    public GUIManager(){
        // Initialize
        game = new DropCatcher();
        frame = new GameFrame();
        menu = new MenuScreen(this);
        instructions = new InstructionsPanel(this);
        credits = new CreditsPanel(this);

        gameScreen = new GameScreen(game);
        onStartup();
    }

    private void onStartup(){
        frame.setVisible(true);
        frame.swapScreen(menu);
    }

    public void startGame(){
        //DEBUG
        System.out.println(game.getClass().getSimpleName() + "=started;");
        frame.swapScreen(gameScreen);
    }

    public void showInstructions(){
        frame.swapScreen(instructions);
    }

    public void hideInstructions(){
        frame.swapScreen(menu);
    }

    public void showSettings(){

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


}
