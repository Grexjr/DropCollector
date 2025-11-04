package newgui;

import newcontroller.GUIManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {

    private final GUIManager manager;
    private final ActionListener buttonListener;

    public GameOverPanel(GUIManager manager){
        this.manager = manager;
        this.buttonListener = buildButtonListener();

        setLayout(new BorderLayout());
        setBackground(GUIConstants.TRANSLUCENT);

        add(buildGameOverLabel(),BorderLayout.CENTER);
        add(buildButtonPanel(),BorderLayout.SOUTH);
    }

    private ActionListener buildButtonListener(){
        return e -> {
            if(e.getActionCommand().equalsIgnoreCase("RESTART")){
                manager.restartGame();
            } else if(e.getActionCommand().equalsIgnoreCase("MAIN MENU")){
                manager.returnToMenu();
            }
        };
    }

    private JLabel buildGameOverLabel(){
        JLabel gameOver = new JLabel(GUIConstants.GAME_OVER_STRING);
        gameOver.setFont(new Font("Gabriola", Font.BOLD,GUIConstants.GAME_OVER_SIZE));
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);
        return gameOver;
    }

    private JPanel buildButtonPanel(){
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel,BoxLayout.X_AXIS));
        buttonPanel.setBackground(GUIConstants.TRANSLUCENT);
        buttonPanel.add(buildRestartButton());
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(buildMainMenuButton());
        return buttonPanel;
    }

    private JButton buildRestartButton(){
        JButton restart = new JButton(GUIConstants.RESTART_STRING);
        restart.setFont(new Font("Gabriola",Font.PLAIN,GUIConstants.BUTTON_TEXT_SIZE));
        restart.addActionListener(buttonListener);
        restart.setAlignmentX(CENTER_ALIGNMENT);
        restart.setAlignmentY(CENTER_ALIGNMENT);
        restart.setPreferredSize(new Dimension(500,getPreferredSize().height));
        return restart;
    }

    private JButton buildMainMenuButton(){
        JButton mainMenu = new JButton(GUIConstants.MAIN_MENU_STRING);
        mainMenu.setFont(new Font("Gabriola",Font.PLAIN,GUIConstants.BUTTON_TEXT_SIZE));
        mainMenu.addActionListener(buttonListener);
        mainMenu.setAlignmentX(CENTER_ALIGNMENT);
        mainMenu.setAlignmentY(CENTER_ALIGNMENT);
        mainMenu.setPreferredSize(new Dimension(500,getPreferredSize().height));
        return mainMenu;
    }






}
