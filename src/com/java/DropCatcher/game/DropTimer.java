package com.java.DropCatcher.game;

import com.java.DropCatcher.objects.Drop;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DropTimer {

    private final DropCatcher game;
    private final Timer timer;

    private long startTime = -1;
    private float duration = 1000f;

    private double dropSpeedMod = 0;

    public DropTimer(DropCatcher game){
        this.game = game;
        timer = new Timer(GameConstants.TIMER_RATE,onTimerComplete());
    }

    public Timer getTimer(){return timer;}
    public double getDropSpeedMod(){return dropSpeedMod;}

    private void decDuration(){
        duration -= GameConstants.DURATION_DEC_INTERVAL;
    }

    private ActionListener onTimerComplete(){
        return new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //if game started

                // if game over not true
                if(!game.getGameOver()){
                    // Use current time for start time
                    if (startTime < 0) {
                        startTime = System.currentTimeMillis();
                    }
                    long now = System.currentTimeMillis();
                    float clockTime = now - startTime;
                    if (clockTime > duration) {
                        game.createDrop();
                        // If above minimum duration, decrease interval between drops
                        if (duration > GameConstants.MINIMUM_DURATION) {
                            decDuration();
                        }
                        // If below minimum duration, increase speed of drops
                        else if (duration <= GameConstants.MINIMUM_DURATION) {
                            dropSpeedMod += 0.1;
                        }
                        startTime = System.currentTimeMillis();
                    }

                    for (int i = game.getDropsList().size() - 1; i >= 0; i--) {
                        game.moveDropDown(game.getDropsList().get(i));
                    }

                    game.getContent().repaint();
                }
            }
        };
    }


}
