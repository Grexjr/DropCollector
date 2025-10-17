package com.java.DropCatcher.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameFrame extends JFrame {

    public GameFrame(){
        // Set up the JFrame
        setTitle(GUIConstants.WINDOW_TITLE);
        setLayout(null);
        setSize(new Dimension(GUIConstants.WINDOW_SIZE[0], GUIConstants.WINDOW_SIZE[1]));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setContentPane(new BackgroundPanel());

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

    private void onMouseInput(){

    }



}
