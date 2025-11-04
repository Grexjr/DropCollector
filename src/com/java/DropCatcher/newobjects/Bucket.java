package com.java.DropCatcher.newobjects;

import com.java.DropCatcher.util.SpriteLoader;
import com.java.DropCatcher.newobjects.abstracta.AbstractObject;

import java.awt.image.BufferedImage;

public class Bucket extends AbstractObject {

    private static final BufferedImage SPRITE = SpriteLoader.loadSprite(ObjectConstants.PLAYER_SPRITE_FILE);

    public Bucket(){
        super(SPRITE);
    }

    @Override
    public void init(GameWorld world){
        setAbsWidth((int) (world.getWidth() * ObjectConstants.BUCKET_SCALE_FACTOR));
        setAbsHeight((int) (world.getHeight() * (ObjectConstants.BUCKET_SCALE_FACTOR *1.5)));

        setAbsX((world.getWidth()/2) - (this.getAbsWidth()/2));
        setAbsY((world.getHeight() - this.getAbsHeight()));

        updateRectangle();
    }

    public void moveBucket(int xPos){
        setAbsX(xPos);
    }

}
