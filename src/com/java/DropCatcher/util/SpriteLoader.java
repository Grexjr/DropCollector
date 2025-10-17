package com.java.DropCatcher.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class SpriteLoader {

    public static BufferedImage loadSprite(String assetFileName){
        BufferedImage sprite = null;
        try{
            sprite = ImageIO.read(
                    Objects.requireNonNull(SpriteLoader.class.getResource(String.format(
                            "/assets/%s",
                            assetFileName)))
            );
        } catch(IOException e){
            e.printStackTrace();
        }
        return sprite;
    }



}
