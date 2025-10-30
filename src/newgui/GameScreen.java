package newgui;

import newcontroller.DropCatcher;
import newcontroller.GUIManager;
import newgui.abstracta.AbstractScreen;
import com.java.DropCatcher.util.CommonConstants;
import newobjects.abstracta.AbstractObject;

import java.awt.*;

public class GameScreen extends AbstractScreen {

    private final DropCatcher game;

    public GameScreen(DropCatcher game){
        super(null,GUIConstants.GAME_BACKGROUND);
        this.game = game;

        add(game.getObjects().getBucket());
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.drawImage(
                game.getObjects().getBucket().getSprite(),
                game.calculateScreenXPos(game.getObjects().getBucket()),
                game.calculateScreenYPos(game.getObjects().getBucket()),
                game.calculateScreenDimension(game.getObjects().getBucket().getAbsWidth()),
                game.calculateScreenDimension(game.getObjects().getBucket().getAbsHeight()),
                null
                );
    }

}
