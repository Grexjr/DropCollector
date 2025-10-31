package newgui;

import newgui.GUIConstants;
import newcontroller.GUIManager;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {


    public GameFrame(){
        // Set up the JFrame
        setTitle(GUIConstants.WINDOW_TITLE);
        setLayout(null);
        setMinimumSize(new Dimension(GUIConstants.WINDOW_SIZE[0], GUIConstants.WINDOW_SIZE[1]));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public Container getContent(){return getContentPane();}

    public void swapScreen(Container newScreen){
        setContentPane(newScreen);
        repaint();
        revalidate();
    }


}
