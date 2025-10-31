package newcontroller;

import newobjects.Bucket;
import newobjects.Droplet;
import newobjects.GameWorld;
import newobjects.ObjectConstants;

import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

    private final GameWorld world;
    private final Bucket bucket;
    private final ArrayList<Droplet> droplets;
    private final Random rand;

    public ObjectManager(){
        world = new GameWorld(ObjectConstants.WORLD_WIDTH,ObjectConstants.WORLD_HEIGHT);
        bucket = new Bucket();
        droplets = new ArrayList<>();
        rand = new Random();

        // Init the bucket before putting it to the screen
        bucket.init(world);
        createDroplet();
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

    public void createDroplet(){
        Droplet droplet = new Droplet();
        droplet.init(world);
        randomizeDropPosition(droplet);
        droplets.add(droplet);
    }

    private void randomizeDropPosition(Droplet d){
        int randomX = rand.nextInt(d.getAbsWidth(),world.getWidth() - d.getAbsWidth());
        d.setAbsX(randomX);
    }
}
