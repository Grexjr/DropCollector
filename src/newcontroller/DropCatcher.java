package newcontroller;

import newobjects.abstracta.AbstractObject;

public class DropCatcher {

    private final GUIManager gui;
    private final ObjectManager objects;

    public DropCatcher(GUIManager gui){
        this.gui = gui;
        objects = new ObjectManager();
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






}
