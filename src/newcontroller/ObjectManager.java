package newcontroller;

import newobjects.Bucket;
import newobjects.Droplet;
import newobjects.GameWorld;
import newobjects.ObjectConstants;

import java.util.ArrayList;

public class ObjectManager {

    private final GameWorld world;
    private final Bucket bucket;
    private final ArrayList<Droplet> droplets;

    public ObjectManager(){
        world = new GameWorld(ObjectConstants.WORLD_WIDTH,ObjectConstants.WORLD_HEIGHT);
        bucket = new Bucket();
        droplets = new ArrayList<>();

        // Init the bucket before putting it to the screen
        bucket.init(world);
    }

    public GameWorld getWorld() {
        return world;
    }

    public Bucket getBucket() {
        return bucket;
    }

    public ArrayList<Droplet> getDroplets() {
        return droplets;
    }
}
