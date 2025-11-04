package com.java.DropCatcher.newobjects;

import com.java.DropCatcher.util.SpriteLoader;
import com.java.DropCatcher.newobjects.abstracta.AbstractObject;

import java.awt.*;

public class Droplet extends AbstractObject {

    public Droplet(){
        super(SpriteLoader.loadSprite(ObjectConstants.DROPLET_SPRITE_FILE));
    }

    @Override
    public void init(GameWorld world){
        setAbsWidth((int) (world.getWidth() * ObjectConstants.DROPLET_SCALE_FACTOR));
        setAbsHeight((int) (world.getHeight() * ObjectConstants.DROPLET_SCALE_FACTOR * 3));

        // Default position of 0 , 0 before being set in the randomize method
        setAbsX(0);
        setAbsY(0);
    }

    public void moveDroplet(int baseSpeed, double modifier){
        //DEBUG
        //System.out.println("DropletSpeed="+(ObjectConstants.OBJECT_MOVE_SPEED * modifier));
        setAbsY(Math.toIntExact(getAbsY()+Math.round(baseSpeed * modifier)));
    }

    public boolean checkDropCollision(Rectangle collider){
        return this.getRectangle().intersects(collider);
    }



}
