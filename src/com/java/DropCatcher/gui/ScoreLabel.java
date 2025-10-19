package com.java.DropCatcher.gui;

import javax.swing.*;
import java.awt.*;

public class ScoreLabel extends JLabel {


    public ScoreLabel(){
        super(String.format("%s %d",GUIConstants.SCORE_STRING,0));
        setBounds(0,0,GUIConstants.SCORE_SIZE[0],GUIConstants.SCORE_SIZE[1]);
        setFont(new Font("Arial",Font.BOLD,50));
        setForeground(new Color(255,255,255));

        setVisible(true);
    }


    public void updateScore(int score){
        this.setText(String.format("%s %d",GUIConstants.SCORE_STRING,score));
        repaint();
    }





}
