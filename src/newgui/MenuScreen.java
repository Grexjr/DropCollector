package newgui;

import newcontroller.GUIManager;
import newgui.abstracta.AbstractScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MenuScreen extends AbstractScreen {

    private final GUIManager manager;
    private final ActionListener buttonListener;

    private final InstructionsPanel instructionsPanel;

    public MenuScreen(GUIManager manager){
        super(null,null);
        this.manager = manager;
        buttonListener = buildActionListener();
        instructionsPanel = new InstructionsPanel(this.manager);

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // Set the background to be black (no screen behind it to show)
        setBackground(Color.BLACK);

        // Add the components
        add(buildTitleLabel());
        add(buildStartButton());
        add(buildInstructionsButton());
        add(buildSettingsButton());

    }

    private ActionListener buildActionListener(){
        return e -> {
            //DEBUG
            System.out.println(e.getActionCommand()+"=pressed");
            switch(e.getActionCommand()){
                case GUIConstants.START_BUTTON_STRING -> manager.startGame();
                case GUIConstants.INSTRUCTIONS_BUTTON_STRING -> manager.showInstructions();
                case GUIConstants.SETTINGS_BUTTON_STRING -> manager.showSettings();
            }
        };
    }

    private JLabel buildTitleLabel(){
        JLabel title = new JLabel(GUIConstants.GAME_TITLE);
        title.setFont(new Font("Gabriola",Font.BOLD,GUIConstants.TITLE_SIZE));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(CENTER_ALIGNMENT);
        return title;
    }

    private JButton buildStartButton(){
        JButton start = new JButton(GUIConstants.START_BUTTON_STRING);
        start.setFont(new Font("Gabriola",Font.PLAIN,GUIConstants.BUTTON_TEXT_SIZE));
        //TODO: Customize button more
        start.addActionListener(buttonListener);
        start.setAlignmentX(CENTER_ALIGNMENT);
        return start;
    }

    private JButton buildInstructionsButton(){
        JButton instructions = new JButton(GUIConstants.INSTRUCTIONS_BUTTON_STRING);
        instructions.setFont(new Font("Gabriola",Font.PLAIN,GUIConstants.BUTTON_TEXT_SIZE));
        //TODO: Customize button more
        instructions.addActionListener(buttonListener);
        instructions.setAlignmentX(CENTER_ALIGNMENT);
        return instructions;
    }

    private JButton buildSettingsButton(){
        JButton settings = new JButton(GUIConstants.SETTINGS_BUTTON_STRING);
        settings.setFont(new Font("Gabriola",Font.PLAIN,GUIConstants.BUTTON_TEXT_SIZE));
        //TODO: Customize button more
        settings.addActionListener(buttonListener);
        settings.setAlignmentX(CENTER_ALIGNMENT);
        return settings;
    }



}
