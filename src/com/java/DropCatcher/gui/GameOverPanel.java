package com.java.DropCatcher.gui;

import com.java.DropCatcher.game.DropCatcher;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {

    private DropCatcher dropCatch;

    public GameOverPanel(DropCatcher game){
        // Add reference to the game
        dropCatch = game;

        // Set the layout of the panel
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // Set the bounds of the panel I guess relative to the component
        setBounds(0,0,GUIConstants.GAME_OVER_PANEL_SIZE[0], GUIConstants.GAME_OVER_PANEL_SIZE[1]);

        // Set the color to be a roughly transparent gray
        setBackground(new Color(20,20,10,50));

        // Add the game over label, restart button
        addGameOverLabel();
        addRestartButton();
    }

    private void addGameOverLabel(){
        JLabel gameOverLabel = new JLabel(GUIConstants.GAME_OVER_STRING);
        gameOverLabel.setFont(new Font("ARIAL",Font.BOLD,75));
        gameOverLabel.setForeground(Color.WHITE);
        add(gameOverLabel);
        gameOverLabel.setVisible(true);
    }

    private void addRestartButton(){
        JButton restartButton = new JButton(GUIConstants.RESTART_BUTTON_STRING);
        restartButton.addActionListener(_ ->{
            dropCatch.hideRestart();
            dropCatch.restartGame();
        });
        add(restartButton);
    }



}
