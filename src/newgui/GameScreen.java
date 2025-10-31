package newgui;

import newcontroller.DropCatcher;
import newgui.abstracta.AbstractScreen;
import newobjects.Bucket;
import newobjects.Droplet;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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
        Graphics2D g2 = (Graphics2D)g;

        drawPlayer(g2);
        drawDrops(g2);
    }

    private void drawDrops(Graphics2D g2){
        ArrayList<Droplet> drops = game.getObjects().getDroplets();

        for(Droplet d : drops){
            Rectangle dRect = (Rectangle)d.getRectangle();

            dRect.setBounds(
                    game.calculateScreenXPos(d),
                    game.calculateScreenYPos(d),
                    game.calculateScreenDimension(d.getAbsWidth()),
                    game.calculateScreenDimension(d.getAbsHeight())
            );

            g2.drawImage(
                    d.getSprite(),
                    (int)dRect.getX(),
                    (int)dRect.getY(),
                    (int)dRect.getWidth(),
                    (int)dRect.getHeight(),
                    null
            );
        }
    }

    private void drawPlayer(Graphics2D g2){
        Bucket player = game.getObjects().getBucket();
        Rectangle playerRect = (Rectangle)player.getRectangle();

        playerRect.setBounds(
                game.calculateScreenXPos(player),
                game.calculateScreenYPos(player),
                game.calculateScreenDimension(player.getAbsWidth()),
                game.calculateScreenDimension(player.getAbsHeight())
        );

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
            public void mousePressed(MouseEvent e) {
                onMousePress(e);
            }

            @Override
            public void mouseDragged(MouseEvent e){
                onMouseDrag(e);
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
    }

    private void onMouseDrag(MouseEvent e){
        isPressed = true;
        mouseX = e.getX();
    }

    private void onMouseReleased(MouseEvent e){
        //DEBUG
        System.out.println(e.getSource()+"=released;");
        isPressed = false;
    }

}
