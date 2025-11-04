package newgui;

import newcontroller.GUIManager;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class InstructionsPanel extends JPanel {

    private final GUIManager manager;
    private final ActionListener buttonListener;

    public InstructionsPanel(GUIManager manager){
        this.manager = manager;
        this.buttonListener = buildActionListener();
        // Set layout
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        // Add components
        add(buildInstructionsText());
        add(buildBackButton());
    }

    private JTextArea buildInstructionsText(){
        JTextArea text = new JTextArea(GUIConstants.INSTRUCTIONS_TEXT);
        text.setEditable(false);
        text.setFocusable(false);
        text.setLineWrap(true);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Gabriola",Font.PLAIN,GUIConstants.INSTRUCTIONS_TEXT_SIZE));
        text.setAlignmentX(CENTER_ALIGNMENT);
        return text;
    }

    private JButton buildBackButton(){
        JButton back = new JButton(GUIConstants.BACK_BUTTON_STRING);
        back.setFont(new Font("Gabriola",Font.PLAIN,GUIConstants.BUTTON_TEXT_SIZE));
        back.addActionListener(buttonListener);
        back.setAlignmentX(CENTER_ALIGNMENT);
        return back;
    }

    private ActionListener buildActionListener(){
        return e -> {
            manager.hideInstructions();
        };
    }








}
