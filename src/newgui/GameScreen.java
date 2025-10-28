package newgui;

import newcontroller.DropCatcher;
import newcontroller.GUIManager;
import newgui.abstracta.AbstractScreen;
import com.java.DropCatcher.util.CommonConstants;

public class GameScreen extends AbstractScreen {

    private final DropCatcher game;

    public GameScreen(DropCatcher game){
        super(null,GUIConstants.GAME_BACKGROUND);
        this.game = game;
    }

}
