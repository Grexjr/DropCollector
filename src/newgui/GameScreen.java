package newgui;

import newcontroller.DropCatcher;
import newgui.abstracta.AbstractScreen;
import newobjects.Bucket;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameScreen extends AbstractScreen {

    private final DropCatcher game;
    private final MouseAdapter mouseAdapter;

    private boolean isPressed;
    private int mouseX;

    public GameScreen(DropCatcher game){
        super(null,GUIConstants.GAME_BACKGROUND);
        this.game = game;
        mouseAdapter = buildMouseInput();
        isPressed = false;

        add(game.getObjects().getBucket());
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public boolean getPressed(){return isPressed;}
    public int getMouseX(){return mouseX;}

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Bucket player = game.getObjects().getBucket();
        Rectangle playerRect = (Rectangle)player.getRectangle();
        Graphics2D g2 = (Graphics2D)g;

        playerRect.setBounds(
                game.calculateScreenXPos(player),
                game.calculateScreenYPos(player),
                game.calculateScreenDimension(player.getAbsWidth()),
                game.calculateScreenDimension(player.getAbsHeight())
        );

        game.getObjects().getBucket().setRectangle(playerRect);

        g2.drawImage(
                player.getSprite(),
                (int)playerRect.getX(),
                (int)playerRect.getY(),
                (int)playerRect.getWidth(),
                (int)playerRect.getHeight(),
                null
        );


    }

    private MouseAdapter buildMouseInput(){
        return new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e){
                onMousePress(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                onMouseReleased(e);
            }
        };
    }

    private void onMousePress(MouseEvent e){
        //DEBUG
        System.out.println(e.getSource()+"=clicked;");
        isPressed = true;
        mouseX = e.getX();
    }

    private void onMouseReleased(MouseEvent e){
        //DEBUG
        System.out.println(e.getSource()+"=released;");
        isPressed = false;
    }

}
