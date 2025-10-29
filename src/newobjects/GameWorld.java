package newobjects;

public class GameWorld {

    private final int width,height;
    private double friction;

    public GameWorld(int width, int height){
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

}
