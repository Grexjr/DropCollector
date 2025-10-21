package com.java.DropCatcher.gui;

import javax.swing.*;
import java.awt.*;

public class HighScoreLabel extends JLabel {

    public HighScoreLabel(){
        super(String.format("%s %d",GUIConstants.HIGH_SCORE_STRING,0));
        setBounds(0,0,GUIConstants.HIGH_SCORE_SIZE[0],GUIConstants.HIGH_SCORE_SIZE[1]);
        setFont(new Font("Arial",Font.BOLD,20));
        setForeground(new Color(255,255,255));

        setVisible(true);
    }

    public void updateScore(int score){
        setText(String.format("%s %d",GUIConstants.HIGH_SCORE_STRING,score));
    }



}
