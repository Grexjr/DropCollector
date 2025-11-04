package com.java.DropCatcher.newcontroller;

import javax.swing.*;

import static com.java.DropCatcher.newcontroller.GameConstants.TARGET_FPS;

public class GameLoop {

    private final Timer loop;
    private final DropCatcher game;

    public GameLoop(DropCatcher game){
        loop = buildGameLoop();
        this.game = game;
    }

    protected void start(){
        //DEBUG
        //System.out.println(this.getClass().getSimpleName()+"=started;");
        loop.start();
    }

    protected void stop(){
        loop.stop();
    }

    private Timer buildGameLoop(){
        int delay = 1000/TARGET_FPS;
        return new Timer(
                delay,
                e -> game.update()
        );
    }




}
