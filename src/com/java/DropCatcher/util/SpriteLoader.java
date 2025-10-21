package com.java.DropCatcher.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class SpriteLoader {

    private static BufferedImage bucketSprite,dropSprite,heartSprite,backgroundSprite;
    private static final Map<String, BufferedImage> spriteCache = new HashMap<>();

    public static void init(){
        bucketSprite = loadSprite("Bucket.png");
        dropSprite = loadSprite("DropBlurred.png");
        heartSprite = loadSprite("HeartSprite.png");
        backgroundSprite = loadSprite("BeautifulBackGround.png");
        spriteCache.put("Bucket.png",bucketSprite);
        spriteCache.put("DropBlurred.png",dropSprite);
        spriteCache.put("HeartSprite.png",heartSprite);
        spriteCache.put("BeautifulBackGround.png",backgroundSprite);
    }

    // Online better load sprite method from cache--hopefully prevents memory usage being high
    public static BufferedImage loadSprite(String assetFileName){
        return spriteCache.computeIfAbsent(assetFileName, key -> {
            try (InputStream is = SpriteLoader.class.getResourceAsStream("/assets/"+key)){
                if(is == null){
                    throw new IOException("Resource not found: "+key);
                }
                return ImageIO.read(is);
            } catch (IOException e){
                e.printStackTrace();
                return null;
            }
        });
    }



}
