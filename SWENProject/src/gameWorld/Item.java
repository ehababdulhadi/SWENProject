package gameWorld;

import java.awt.Image;
import java.util.Map;

public class Item {
	
	private String itemName;
	private String itemDescription;
	private Room itemRoom;
	private Image itemImage;
	
	
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


}
