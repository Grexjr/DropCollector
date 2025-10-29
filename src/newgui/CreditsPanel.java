package newgui;

import newcontroller.GUIManager;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;
import java.awt.event.ActionListener;

public class CreditsPanel extends JPanel {

    private final GUIManager manager;
    private final ActionListener buttonListener;

    public CreditsPanel(GUIManager manager){
        this.manager = manager;
        this.buttonListener = createButtonListener();

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        add(buildCredits());
        add(buildBackButton());
    }

    private ActionListener createButtonListener(){
        return e -> {
          manager.hideCredits();
        };
    }

    private JTextPane buildCredits(){
        JTextPane text = new JTextPane();
        text.setText(GUIConstants.CREDITS_TEXT);
        // Get the styled document
        StyledDocument doc = text.getStyledDocument();
        // Create a SimpleAttributeSet to center
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);

        // Try catch block for the alignment
        doc.setParagraphAttributes(0,doc.getLength(),center,false);

        text.setEditable(false);
        text.setFocusable(false);
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



}
