package newobjects;

import com.java.DropCatcher.util.SpriteLoader;
import newobjects.abstracta.AbstractObject;

import java.awt.image.BufferedImage;

public class Bucket extends AbstractObject {

    private static final BufferedImage SPRITE = SpriteLoader.loadSprite(ObjectConstants.PLAYER_SPRITE_FILE);

    public Bucket(){
        super(SPRITE);
    }

    @Override
    public void init(GameWorld world){
        setAbsWidth((int) (world.getWidth() * ObjectConstants.OBJECT_SCALE_FACTOR));
        setAbsHeight((int) (world.getHeight() * ObjectConstants.OBJECT_SCALE_FACTOR));

        setAbsX((world.getWidth()/2));
        setAbsY((world.getHeight() - this.getAbsHeight()));
    }

    public void moveBucket(int xPos){
        setAbsX(xPos);
    }

}
