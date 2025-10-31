package newgui;

import newcontroller.GUIManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class SettingsPanel extends JPanel {

    private final GUIManager manager;
    private final ActionListener buttonListener;

    public SettingsPanel(GUIManager manager){
        this.manager = manager;
        this.buttonListener = createButtonListener();
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        add(buildBackButton());
    }


    private ActionListener createButtonListener(){
        return e -> {
            manager.hideSettings();
        };
    }

    private JButton buildBackButton(){
        JButton back = new JButton(GUIConstants.BACK_BUTTON_STRING);
        back.setFont(new Font("Gabriola",Font.PLAIN,GUIConstants.BUTTON_TEXT_SIZE));
        back.addActionListener(buttonListener);
        back.setAlignmentX(CENTER_ALIGNMENT);
        return back;
    }







}
