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
    
    public void addItem(Drawable item){
        contents.add(item);
    }
    
    public void removeItem(Drawable item){
         contents.remove(item);
    }
    
    public void removeItems(){
    		contents.clear();
    }
}
