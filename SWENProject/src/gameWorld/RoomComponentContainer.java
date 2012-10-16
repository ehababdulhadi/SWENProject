package gameWorld;

import java.util.ArrayList;

/**
 *
 * @author Rudi Theunissen
 */
public class RoomComponentContainer extends RoomComponent {
	
	private int health = 100;
    private ArrayList<RoomComponent> contents = new ArrayList<RoomComponent>();

    public RoomComponentContainer(double x, double y, double w, double h, String imagePath) {
        super(x, y, w, h, imagePath);
    }
    
    public void setHealth(int health){
    	this.health = health;
    }
    
    public int getHealth(){
    	return health;
    }
    
    public boolean isDead(){
    	if(health<=0){
    		return true;
    	}
    	else
    		return false;
    }
    public ArrayList<RoomComponent> getContents() {
        return contents;
    }

    public void addItem(RoomComponent item) {
        contents.add(item);
    }

    public void removeItem(RoomComponent item) {
        contents.remove(item);

    }

    public void removeItems() {
        contents.clear();
    }
}
