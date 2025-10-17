package com.java.DropCatcher.gui;

import com.java.DropCatcher.game.DropCatcher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {

    public GameFrame(DropCatcher game){
        // Set up the JFrame
        setTitle(GUIConstants.WINDOW_TITLE);
        setLayout(null);
        setSize(new Dimension(GUIConstants.WINDOW_SIZE[0], GUIConstants.WINDOW_SIZE[1]));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(new BackgroundPanel(game));

        // Add the mouse listener for controls
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                onMouseInput();
            }
        });

        // Set the frame to be visible
        setVisible(true);
    }


    public void paintComponent(Graphics g){

    }


    private void onMouseInput(){
        // Move the bucket to the mouse X position, NOT THE Y POSITION
    }




}
