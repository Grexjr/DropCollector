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
        setAbsWidth((int) (world.getWidth() * ObjectConstants.OBJECT_SCALE_FACTOR));
        setAbsHeight((int) (world.getHeight() * ObjectConstants.OBJECT_SCALE_FACTOR * 2));

        // No setting position, occurs in the game method
    }

    public void moveDroplet(){
        setAbsY(getAbsY()-ObjectConstants.OBJECT_MOVE_SPEED);
    }



}
