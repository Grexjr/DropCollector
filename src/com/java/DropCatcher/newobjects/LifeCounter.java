package com.java.DropCatcher.newobjects;

import com.java.DropCatcher.util.SpriteLoader;
import com.java.DropCatcher.newobjects.abstracta.AbstractObject;

public class LifeCounter extends AbstractObject {

    private int offset;

    public LifeCounter(){
        super(SpriteLoader.loadSprite(ObjectConstants.LIFE_SPRITE_FILE));
    }

    public void setOffset(int offset){this.offset = offset;}

    public void init(GameWorld world){
        setAbsWidth((int) (world.getWidth() * ObjectConstants.LIFE_COUNTER_SCALE_FACTOR));
        setAbsHeight((int) (world.getHeight() * ObjectConstants.LIFE_COUNTER_SCALE_FACTOR * 2));

        setAbsX(world.getWidth() - (getAbsWidth() + offset));
        setAbsY(0);
    }




}
