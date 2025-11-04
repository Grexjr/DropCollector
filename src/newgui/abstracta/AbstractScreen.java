package newgui.abstracta;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class AbstractScreen extends JPanel {

    protected BufferedImage bgImage;

    public AbstractScreen(LayoutManager layout, BufferedImage bgImage){
        super(layout);
        this.bgImage = bgImage;
    }

    public void drawBackground(Graphics g){
        if(bgImage != null){
            g.drawImage(bgImage,0,0,getWidth(),getHeight(),null);
        }
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        drawBackground(g);
    }

    ///  Disposes of the assets on the screen
    public void dispose(){
        if(bgImage != null){
            bgImage.flush();
            bgImage = null;
        }
    }

}
