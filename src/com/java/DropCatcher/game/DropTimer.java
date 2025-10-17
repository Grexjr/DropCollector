package com.java.DropCatcher.game;

import com.java.DropCatcher.objects.Drop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropTimer {

    private static final float DURATION_DEC_INTERVAL = 0.25f;
    private static final int TIMER_RATE = 10;

    private final DropCatcher game;
    private final Timer timer;

    private long startTime = -1;
    private float duration = 400;

    public DropTimer(DropCatcher game){
        this.game = game;
        timer = new Timer(TIMER_RATE,onTimerComplete());
    }

    public Timer getTimer(){return timer;}

    private void decDuration(){duration -= DURATION_DEC_INTERVAL;}


    private ActionListener onTimerComplete(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //if game started
                // if game over not true

                decDuration();

                // Use current time for start time
                if(startTime < 0){
                    startTime = System.currentTimeMillis();
                }
                long now = System.currentTimeMillis();
                float clockTime = now - startTime;
                if(clockTime > duration){
                    //game.createDrop();
                }

                for(Drop d : game.getDropsList()){
                    game.moveDropDown(d);
                }
            }
        };
    }


}
