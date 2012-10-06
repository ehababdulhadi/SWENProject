package gameWorld;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Map;

public class Item {
	
	private String itemName;
	private String itemDescription;
	private Room itemRoom;
	private Image itemImage;
	private ArrayList<Item> chestItems = new ArrayList<Item>(); // To be used if the item is a box which can include other items //
	private boolean isChest = false;
	
	public Item(String name, String description, Room room, Image image) {
		
		this.itemName = name;
		this.itemDescription = description;
		this.itemRoom = room;
		this.itemImage = image;
		
	}
	
	public String getItem_name(){
		return this.itemName;
	}

	public String getItem_descrpition() {
		return itemDescription;
	}

	public void setItem_Location(Room item_Location) {
		this.itemRoom = item_Location;
	}

	public Room getItem_Location() {
		return itemRoom;
	}

	public Image getItemImage() {
		return itemImage;
	}

	public ArrayList<Item> getChest() {
		return chestItems;
	}

	public void setChest(ArrayList<Item> chest) {
		this.chestItems = chest;
	}

	public boolean isChest() {
		return isChest;
	}

	public void setChest(boolean isChest) {
		this.isChest = isChest;
	}


}
