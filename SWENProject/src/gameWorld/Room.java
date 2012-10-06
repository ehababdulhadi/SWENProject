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
/** Represents a Room, which can contain a Player, Zombie, Item and Doors
 * 
 */
public class Room {
	
	private String roomName;
	private String roomDescription;
	private ImageIcon roomBackground;
	private ArrayList<Item> itemsOfTheRoom = new ArrayList<Item>();
	private ArrayList<Player> playersInTheRoom = new ArrayList<Player>();
	private Zombie zombieOfTheRoom = null;
	private boolean hasZombie = false;
	private ArrayList<Door> doorsOfTheRoom = new ArrayList<Door>();
	Random randomGenerator = new Random();


	public Room(String name, ImageIcon background, String description){
			
		this.roomName = name;
		this.roomDescription = description;
		this.roomBackground = background;
		//this.setItemsOfTheRoom(items);
		//this.playersInTheRoom = players;
		//this.zombieOfTheRoom = zombie;
		//this.doorsOfTheRoom = doors;
		
    	/*if (!(zombie == null))
    			this.hasZombie = true; **/
		}

	public String getLocation_name() {
		return roomName;
	}
	
	public String getLocation_description() {
		return roomDescription;
	}

	public ArrayList<Player> getPlayers_in_location_ArrayList() {
		return playersInTheRoom;
	}

	public Zombie getZombie() {
		return zombieOfTheRoom;
	}

	public boolean isHasZombie() {
		return hasZombie;
	}

	public void setHasZombie(boolean hasZombie) {
		this.hasZombie = hasZombie;
	}

	public ArrayList<Door> getDoorsOfTheRoom() {
		return doorsOfTheRoom;
	}

	public void setDoorsOfTheRoom(ArrayList<Door> doorsOfTheRoom) {
		this.doorsOfTheRoom = doorsOfTheRoom;
	}

	public ArrayList<Item> getItemsOfTheRoom() {
		return itemsOfTheRoom;
	}

	public void setItemsOfTheRoom(ArrayList<Item> itemsOfTheRoom) {
		this.itemsOfTheRoom = itemsOfTheRoom;
	}

}
