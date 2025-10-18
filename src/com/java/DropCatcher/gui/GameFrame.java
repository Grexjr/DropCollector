package com.java.DropCatcher.gui;

import com.java.DropCatcher.game.DropCatcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {

    private final DropCatcher dropCatcher;
    private Timer holdTimer;

    public GameFrame(DropCatcher game){
        // Create reference to game
        dropCatcher = game;
        holdTimer = null; // Make sure this is okay; no references to it outside when its created

        // Set up the JFrame
        setTitle(GUIConstants.WINDOW_TITLE);
        setLayout(null);
        setSize(new Dimension(GUIConstants.WINDOW_SIZE[0], GUIConstants.WINDOW_SIZE[1]));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(new BackgroundPanel(game));

        // Add the mouse listener for controls
        getContentPane().addMouseListener(new MouseAdapter() {
            // This release starts the timer
            @Override
            public void mousePressed(MouseEvent e) {
                startHoldTimer();
            }
            // This release stops the timer
            @Override
            public void mouseReleased(MouseEvent e){
                stopHoldTimer();
            }
        });

        // Set the frame to be visible
        setVisible(true);
    }

    private void startHoldTimer(){
       // Need to create a timer to deal with mouse being pressed down
            holdTimer = new Timer(0, _ -> {
                int newX = 0;
                if(!(getContentPane().getMousePosition() == null)){
                   newX = Math.toIntExact(Math.round(getContentPane().getMousePosition().getX()));
                }
                if(newX > 0 && newX < getContentPane().getWidth()) {
                    dropCatcher.getBucket().setBounds(
                            newX,
                            dropCatcher.getBucket().getY(),
                            dropCatcher.getBucket().getWidth(),
                            dropCatcher.getBucket().getHeight()
                    );
                    // Ensure bucket stays on screen
                    if(dropCatcher.getBucket().getX() >= getContentPane().getWidth()
                            - dropCatcher.getBucket().getWidth()){
                        dropCatcher.getBucket().setBounds(
                                getContentPane().getWidth() - dropCatcher.getBucket().getWidth(),
                                dropCatcher.getBucket().getY(),
                                dropCatcher.getBucket().getWidth(),
                                dropCatcher.getBucket().getHeight()
                        );
                    }
                }
            });
            holdTimer.start();
    }

    private void stopHoldTimer(){
        holdTimer.stop();
    }




}
