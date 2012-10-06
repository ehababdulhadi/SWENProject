package gameWorld;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.ImageIcon;

public class Item {
	
	private String itemName;
	private String itemDescription;
	private Room itemRoom;
	private ImageIcon itemImage;
	private ArrayList<Item> boxItems = new ArrayList<Item>(); // To be used if the item is a box which can include other items //
	private boolean isBox = false;
	private boolean isLocked = false;
	private boolean isHidden = false;
	
	public Item(String name, String description, Room room, ImageIcon image) {
		
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

	public ImageIcon getItemImage() {
		return itemImage;
	}

	public ArrayList<Item> getBoxItems() {
		return boxItems;
	}

	public void setBoxItems(ArrayList<Item> chest) {
		this.boxItems = chest;
	}

	public boolean isChest() {
		return isBox;
	}

	public void setIsBox(boolean isBox) {
		this.isBox = isBox;
	}

	public boolean boxIsLocked() {
		return isLocked;
	}

	public void boxSetLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public boolean isHidden() {
		return isHidden;
	}

	public void setHidden(boolean isHidden) {
		this.isHidden = isHidden;
	}


}
