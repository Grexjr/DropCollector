package newobjects;

import com.java.DropCatcher.util.SpriteLoader;
import newobjects.abstracta.AbstractObject;

import java.awt.image.BufferedImage;

public class Droplet extends AbstractObject {

    private static final BufferedImage SPRITE = SpriteLoader.loadSprite(ObjectConstants.DROPLET_SPRITE_FILE);

    public Droplet(){
        super(SPRITE);
    }

    @Override
    public void init(GameWorld world){
        setAbsWidth((int) (world.getWidth() * ObjectConstants.DROPLET_SCALE_FACTOR));
        setAbsHeight((int) (world.getHeight() * ObjectConstants.DROPLET_SCALE_FACTOR * 3));

        // Default position of 0 , 0 before being set in the randomize method
        setAbsX(0);
        setAbsY(0);
    }

    public void moveDroplet(){
        setAbsY(getAbsY()+ObjectConstants.OBJECT_MOVE_SPEED);
    }



}
