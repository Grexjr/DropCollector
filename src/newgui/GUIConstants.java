package newgui;

import com.java.DropCatcher.util.CommonConstants;
import com.java.DropCatcher.util.SpriteLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GUIConstants {

    // General variables
    protected static final Color TRANSPARENT = new Color(0,0,0,0);
    protected static final Color TRANSLUCENT = new Color(0,0,0,50);

    protected static final int BUTTON_TEXT_SIZE = 50;

    // Frame variables
    protected static final String WINDOW_TITLE = "Drop Catcher";
    protected static final int[] WINDOW_SIZE = {800,600};

    // Background image variables
    public static final String GAME_BACKGROUND_PATH = "BeautifulBackGround.png";

    // Main menu variables
    protected static final String GAME_TITLE = "DROP CATCHER";
    protected static final int TITLE_SIZE = 100;
    protected static final String START_BUTTON_STRING = "START GAME";
    protected static final String INSTRUCTIONS_BUTTON_STRING = "INSTRUCTIONS";
    protected static final String SETTINGS_BUTTON_STRING = "SETTINGS";
    protected static final String CREDITS_BUTTON_STRING = "CREDITS";

    // Instructions panel variables
    protected static final int INSTRUCTIONS_TEXT_SIZE = 25;
    protected static final String INSTRUCTIONS_TEXT = "INSTRUCTIONS!\n\n" +
            "Click and drag the bucket along the bottom of the screen " +
            "to catch droplets!\nDon't let them fall, or you'll lose a life. Lose three lives, and you lose!\n" +
            "See how high of a score you can get!\nBut beware--the storm is coming, and drops will come harder " +
            "and faster!\n\nTIP: You can only catch drops with the top of your bucket! That's how buckets work, duh.";
    protected static final String BACK_BUTTON_STRING = "BACK";

    // Credits panel variables
    protected static final String CREDITS_TEXT = "CREDITS:\n\n" +
            "Programming: Gavin March\nAssets: Gavin March\nMusic: Dawson March\nBuilt with Java Swing";

    // Game Screen variables
    protected static final String SCORE_LABEL_STRING = "Score: ";
    protected static final int SCORE_SIZE = 50;

}
