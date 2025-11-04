package com.java.DropCatcher.newgui;

import com.java.DropCatcher.util.SpriteLoader;
import com.java.DropCatcher.newcontroller.DropCatcher;
import com.java.DropCatcher.newgui.abstracta.AbstractScreen;
import com.java.DropCatcher.newobjects.Bucket;
import com.java.DropCatcher.newobjects.Droplet;
import com.java.DropCatcher.newobjects.LifeCounter;
import com.java.DropCatcher.newobjects.ObjectConstants;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameScreen extends AbstractScreen {

    private final DropCatcher game;
    private final MouseAdapter mouseAdapter;
    private final ScoreLabel scoreLabel;
    private final HighScoreLabel highScoreLabel;

    private boolean isPressed;
    private int mouseX;

    public GameScreen(DropCatcher game){
        super(null, SpriteLoader.loadSprite(GUIConstants.GAME_BACKGROUND_PATH));
        this.game = game;
        mouseAdapter = buildMouseInput();
        scoreLabel = new ScoreLabel();
        highScoreLabel = new HighScoreLabel(game.getHighScore());

        isPressed = false;

        add(game.getObjects().getBucket());
        for(LifeCounter l : game.getObjects().getLives()){
            add(l);
        }
        add(scoreLabel);
        add(highScoreLabel);
        addMouseListener(mouseAdapter);
        addMouseMotionListener(mouseAdapter);
    }

    public boolean getPressed(){return isPressed;}
    public int getMouseX(){return mouseX;}
    public ScoreLabel getScoreLabel(){return scoreLabel;}
    public HighScoreLabel getHighScoreLabel() {return highScoreLabel;}

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        drawDrops(g2);
        drawPlayer(g2);
        drawLives(g2);
        drawScore();
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
                game.calculateScreenDimension((int) (player.getAbsHeight() * ObjectConstants.BUCKET_COLLISION_MOD))
        );

        g2.drawImage(
                player.getSprite(),
                (int)playerRect.getX(),
                (int)playerRect.getY(),
                (int)playerRect.getWidth(),
                game.calculateScreenDimension(player.getAbsHeight()),
                null
        );
    }

    private void drawLives(Graphics2D g2){
        ArrayList<LifeCounter> lives = game.getObjects().getLives();

        for(LifeCounter l : lives){
            g2.drawImage(
                    l.getSprite(),
                    game.calculateScreenXPos(l),
                    game.calculateScreenYPos(l),
                    game.calculateScreenDimension(l.getAbsWidth()),
                    game.calculateScreenDimension(l.getAbsHeight()),
                    null
            );
        }
    }

    private void drawScore(){
        scoreLabel.setBounds(
                0,
                0,
                scoreLabel.getPreferredSize().width,
                scoreLabel.getPreferredSize().height
        );
        highScoreLabel.setBounds(
                0,
                scoreLabel.getPreferredSize().height/2,
                highScoreLabel.getPreferredSize().width,
                highScoreLabel.getPreferredSize().height
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
        //System.out.println(e.getSource()+"=clicked;");
    }

    private void onMouseDrag(MouseEvent e){
        isPressed = true;
        mouseX = e.getX();
    }

    private void onMouseReleased(MouseEvent e){
        //DEBUG
        //System.out.println(e.getSource()+"=released;");
        isPressed = false;
    }
}
