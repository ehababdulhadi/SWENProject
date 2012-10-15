package gameWorld;

import java.util.ArrayList;

/**
 *
 * @author Rudi Theunissen
 */
public class Chest extends Item{
    
    private ArrayList<Item> contents = new ArrayList<Item>();
    
    public Chest(double x, double y, double w, double h, String imagePath) {
        super(x, y, w, h, imagePath);
    }
    
    public ArrayList<Item> getContents(){
        return contents;
    }
    
    public void addItem(Item item){
        contents.add(item);
    }
    
    public void removeItem(Item item){
         contents.remove(item);
    }
    
    public void removeItems(){
    		contents.clear();
    }
}
