package newgui;

import javax.swing.*;
import java.awt.*;

public class ScoreLabel extends JLabel {

    //TODO: Figure out how to make this resize-safe based on the other infrastructure you have
    public ScoreLabel(){
        super(GUIConstants.SCORE_LABEL_STRING + 0);

        setFont(new Font("Gabriola", Font.PLAIN,GUIConstants.SCORE_SIZE));
        setForeground(Color.WHITE);
    }

    public void updateScore(int newScore){
        setText(GUIConstants.SCORE_LABEL_STRING + newScore);
    }






}
