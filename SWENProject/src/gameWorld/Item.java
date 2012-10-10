package gameWorld;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.swing.border.LineBorder;
import userInterface.CustomComponent;
import userInterface.ResourceLoader;

public class Item extends CustomComponent{
    
    // an item needs
    //  1. an x-postion percentage and a y-position percentage
    //  2. an action that should occur when clicked on
    //  3. a width and height
    //  4. an image path
    
    public final BufferedImage image;
    public final double x, y, w, h;
    
    public Item(double x, double y, double w, double h, String imagePath){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        image = ResourceLoader.openImage(imagePath);
        this.setBorder(new LineBorder(Color.RED));
    }
    
    @Override
    public void paintContent(Graphics2D g) {
        if(image == null) return;
//        double sourceRatio = image.getWidth() / image.getHeight();
//        double currentRatio = getWidth() / getHeight();
//        
//        int w, h;
//        
//        if(sourceRatio > currentRatio){ // 
//            w = getWidth();
//            h = (int)(sourceRatio * getWidth());
//            
//        } else {
//            w = (int)(sourceRatio * getHeight());
//            h = getHeight();
//        }

        if(image != null) g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        System.out.println("paint");
    }

    
//    
//    
//	
//	private String itemName;
//	private String itemDescription;
//	private Room itemRoom;
//	private ImageIcon itemImage;
//	private ArrayList<Item> boxItems = new ArrayList<Item>(); // To be used if the item is a box which can include other items //
//	private boolean isBox = false;
//	private boolean isLocked = false;
//	private boolean isHidden = false;
//	
//	public Item(String name, String description, Room room, ImageIcon image) {
//		
//		this.itemName = name;
//		this.itemDescription = description;
//		this.itemRoom = room;
//		this.itemImage = image;
//		
//	}
//	
//	public String getItem_name(){
//		return this.itemName;
//	}
//
//	public String getItem_descrpition() {
//		return itemDescription;
//	}
//
//	public void setItem_Location(Room item_Location) {
//		this.itemRoom = item_Location;
//	}
//
//	public Room getItem_Location() {
//		return itemRoom;
//	}
//
//	public ImageIcon getItemImage() {
//		return itemImage;
//	}
//
//	public ArrayList<Item> getBoxItems() {
//		return boxItems;
//	}
//
//	public void setBoxItems(ArrayList<Item> chest) {
//		this.boxItems = chest;
//	}
//
//	public boolean isChest() {
//		return isBox;
//	}
//
//	public void setIsBox(boolean isBox) {
//		this.isBox = isBox;
//	}
//
//	public boolean boxIsLocked() {
//		return isLocked;
//	}
//
//	public void boxSetLocked(boolean isLocked) {
//		this.isLocked = isLocked;
//	}
//
//	public boolean isHidden() {
//		return isHidden;
//	}
//
//	public void setHidden(boolean isHidden) {
//		this.isHidden = isHidden;
//	}


}
