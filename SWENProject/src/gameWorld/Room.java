package gameWorld;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;
import userInterface.MainGameWindow;
import userInterface.Drawable;
/** This class helps to create the locations of the game
 * 
 *
 */
public class Room {
	private static final int GRID_WIDTH = 2560;
	private static final int GRID_HEIGHT = 500;
	
	private String location_name;
	private String location_description;
	private ArrayList<Item> itemsList = new ArrayList<Item>();
	private ArrayList<Player> playersList = new ArrayList<Player>();
	private ArrayList<GameItem> objectsList = new ArrayList<GameItem>();
	private ImageIcon location_background; 
	private ImageIcon location_object;
	private ArrayList<Zombie> enemiesList= new ArrayList<Zombie>();
	Random randomGenerator = new Random();
	private Room leftLocation;
	private Room rightLocation;
	private int numberOfEnemies;

	public Room(String name, ImageIcon location_background, ImageIcon location_object, 
			List<ImageIcon> enemy_images, String description){
			
		this.location_name = name;
		this.location_description = description;
		this.location_background = location_background;
		this.location_object = location_object;
		
		// Create the enemies of this location //
		createEnemiesOfTheLocation();
		
		// Create the Stationary Objects of this location //
		createStationaryObjectsOfTheLocation();
		
		}

	
	private void createEnemiesOfTheLocation(){
		
			for (int i=0; i<numberOfEnemies; i++){ 
				int randomXposition = randomGenerator.nextInt(2560); 
				int randomYposition = randomGenerator.nextInt(500); 
				int random = randomGenerator.nextInt(10);
			
				Zombie newEnemy;
				/* create zombies */	
				if (random < 7) {
					//newEnemy = new Zombie(this , randomXposition, randomYposition,  500, 1, /**image of enemy**/, 200, 150, 500);
				}
				else if (random < 9) {
					//newEnemy = new Zombie(this , randomXposition, randomYposition,  1000, 2, /**image of enemy**/, 200, 150, 500);
				}
				else {
					//newEnemy = new Zombie(this , randomXposition, randomYposition,  3000, 4, /**image of enemy**/, 200, 150, 500);
				}
				//getEnemiesList().add(newEnemy);
			}
			
		}
	
	private void createStationaryObjectsOfTheLocation(){
		
		String objectName = null;
			/** Distribute items in the room randomly**/
	}
	
	public String getLocation_name() {
		return location_name;
	}
	
	public String getLocation_description() {
		return location_description;
	}


	public ArrayList<Item> getItems_in_location_ArrayList() {
		return itemsList;
	}


	public ArrayList<Player> getPlayers_in_location_ArrayList() {
		return playersList;
	}

	public ArrayList<GameItem> getObjects_in_location_ArrayList() {
		return objectsList;
	}
	
	public Image getObjectImage(){
		return location_object.getImage();
	}

	public void setLeftLocation(Room leftLocation) {
		this.leftLocation = leftLocation;
	}

	public Room getLeftLocation() {
		return leftLocation;
	}


	public void setRightLocation(Room rightLocation) {
		this.rightLocation = rightLocation;
	}


	public Room getRightLocation() {
		return rightLocation;
	}

	public ArrayList<Zombie> getEnemiesList() {
		return enemiesList;
	}
	
	/**
	 * Method for working out whether all the enemies in a location are dead or not.
	 */
	public boolean areEnemiesDead(){
		for(Zombie z : enemiesList){
			if(z.isDead()==false)
				return false;
		}
		return true;
	}


	public List<GameItem> getCarryableObjects() {
		// TODO Auto-generated method stub
		return null;
	}

}