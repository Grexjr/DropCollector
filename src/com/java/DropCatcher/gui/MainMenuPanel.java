package com.java.DropCatcher.gui;

import com.java.DropCatcher.game.DropCatcher;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    private final DropCatcher dropCatch;

    public MainMenuPanel(DropCatcher game){
        // Add the reference to the game for action listeners and box layout
        dropCatch = game;

        // Set the layout of the panel for vertical box layout
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Set the bounds of the panel with the width and height
        setBounds(0,0,GUIConstants.MAIN_MENU_SIZE[0],GUIConstants.MAIN_MENU_SIZE[1]);

        // Set the background to be fully transparent
        setBackground(new Color(255,255,255,0));

        // Add the title label, start button, and instructions button
        addTitleLabel();
        addStartButton();
        addInstructionsButton();

        // Set the panel to be visible
        setVisible(true);
    }

    private void addTitleLabel(){
        JLabel titleLabel = new JLabel(GUIConstants.GAME_TITLE);
        titleLabel.setFont(new Font("TIMES", Font.BOLD,50));
        titleLabel.setForeground(Color.WHITE);
        add(titleLabel);
        titleLabel.setVisible(true);
    }

    private void addStartButton(){
        // Create the button
        JButton startButton = new JButton(GUIConstants.START_BUTTON_STRING);

        // Add the action listener
        startButton.addActionListener(_ ->{
            setVisible(false);
            setEnabled(false);
            dropCatch.startGame();
        });

        // Add the button to this panel
        add(startButton);
    }

    private void addInstructionsButton(){
        JButton instructionsButton = new JButton(GUIConstants.INSTRUCTIONS_BUTTON_STRING);
        instructionsButton.addActionListener(_ ->{
            dropCatch.showInstructions();
        });
        add(instructionsButton);
    }










}
