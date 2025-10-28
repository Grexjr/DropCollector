package newcontroller;

import newgui.GameFrame;
import newgui.GameScreen;
import newgui.InstructionsPanel;
import newgui.MenuScreen;

public class GUIManager {

    private final DropCatcher game;
    private final GameFrame frame;
    private final MenuScreen menu;
    private final InstructionsPanel instructions;

    // Screens
    private final GameScreen gameScreen;

    public GUIManager(){
        // Initialize
        game = new DropCatcher();
        frame = new GameFrame();
        menu = new MenuScreen(this);
        instructions = new InstructionsPanel(this);

        gameScreen = new GameScreen(game);
        onStartup();
    }

    private void onStartup(){
        frame.setVisible(true);
        frame.swapScreen(menu);
    }

    public void startGame(){}

    public void showInstructions(){
        frame.swapScreen(instructions);
    }

    public void hideInstructions(){
        frame.swapScreen(menu);
    }

    public void showSettings(){}


}
