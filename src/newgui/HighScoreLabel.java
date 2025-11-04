package newgui;

import javax.swing.*;
import java.awt.*;

public class HighScoreLabel extends JLabel {

    public HighScoreLabel(){
        super(GUIConstants.HIGH_SCORE_STRING + 0);
        setFont(new Font("Gabriola", Font.PLAIN,GUIConstants.SCORE_SIZE/2));
        setForeground(Color.WHITE);
    }

    public void updateHighScore(int score){
        setText(GUIConstants.HIGH_SCORE_STRING + score);
    }



}
