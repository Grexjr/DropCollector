package com.java.DropCatcher.gui;

import javax.swing.*;
import java.awt.*;

public class InstructionsText extends JTextArea {

    // Include the text here, basically say that you drag your bucket to catch drops, try to get a high score.

    public InstructionsText(){
        super(GUIConstants.INSTRUCTIONS_TEXT);

        setBackground(Color.GRAY);
        setForeground(Color.WHITE);

        setFont(new Font("TIMES", Font.PLAIN,20));

        setLineWrap(true);
        setEditable(false);
        setFocusable(false);

        setBounds(0,0,GUIConstants.INSTRUCTIONS_TEXT_SIZE[0],GUIConstants.INSTRUCTIONS_TEXT_SIZE[1]);

    }

}
