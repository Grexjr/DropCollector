package newcontroller;

import newobjects.abstracta.AbstractObject;

public class DropCatcher {

    private final GUIManager gui;
    private final ObjectManager objects;
    private final GameLoop loop;

    //TODO: add db mode that draws object rectangles etc.

    public DropCatcher(GUIManager gui){
        this.gui = gui;
        objects = new ObjectManager();
        loop = new GameLoop(this);
    }

    public ObjectManager getObjects(){
        return objects;
    }

    public int calculateScreenXPos(AbstractObject object){
        return (int)(object.getAbsX() * gui.calculateScaleRatioX());
    }

    public int calculateScreenYPos(AbstractObject object){
        return (int)(object.getAbsY() * gui.calculateScaleRatioY());
    }

    public int calculateScreenDimension(int absoluteDimension){
        double scale = Math.min(gui.calculateScaleRatioX(),gui.calculateScaleRatioY());
        return (int)(absoluteDimension * scale);
    }

    public void startLoop(){
        loop.start();
    }

    /// MAIN GAME LOOP - EXECUTES EVERY FRAME
    public void update(){
        // Repaint content pane every frame
        gui.getContent().repaint();

        // Run player input
        if(gui.runGameInput()){
            objects.getBucket().moveBucket(
                    (int)(gui.getClickX()/gui.calculateScaleRatioX()
                            - (double) objects.getBucket().getAbsWidth() /2)
            );

            if((objects.getBucket().getAbsX() + objects.getBucket().getAbsWidth()) > objects.getWorld().getWidth()){
                objects.getBucket().moveBucket(objects.getWorld().getWidth() - objects.getBucket().getAbsWidth());
            }
            if(objects.getBucket().getAbsX() < 0){
                objects.getBucket().moveBucket(0);
            }
        }


    }






}
