package com.java.DropCatcher.gui;

import com.java.DropCatcher.game.DropCatcher;
import com.java.DropCatcher.objects.Drop;

import javax.swing.*;
import java.awt.*;

public class InstructionsTextPanel extends JPanel {

    private final DropCatcher dropCatch;

    public InstructionsTextPanel(DropCatcher game){
        dropCatch = game;

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        setBounds(0,0, GUIConstants.INSTRUCTIONS_PANEL_SIZE[0],GUIConstants.INSTRUCTIONS_PANEL_SIZE[1]);

        add(new InstructionsText());
        setVisible(false);
        setEnabled(false);

        addBackButton();
    }


    private void addBackButton(){
        JButton backButton = new JButton("BACK");
        backButton.addActionListener(_ -> {
            setVisible(false);
            setEnabled(false);
            dropCatch.hideInstructions();
        });
        add(backButton);
    }




}
