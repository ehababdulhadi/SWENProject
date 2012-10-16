package gameWorld;

import java.util.ArrayList;

/**
 *
 * @author Rudi Theunissen
 */
public class Chest extends Drawable{
    
    private ArrayList<Drawable> contents = new ArrayList<Drawable>();
    
    public Chest(double x, double y, double w, double h, String imagePath) {
        super(x, y, w, h, imagePath);
    }
    
    public ArrayList<Drawable> getContents(){
        return contents;
    }
    
    public void addItem(Drawable drawable){
        contents.add(drawable);
    }
    
    public void removeItem(Drawable drawable){
         contents.remove(drawable);
    }
    
    public void removeItems(){
    		contents.clear();
    }
}
