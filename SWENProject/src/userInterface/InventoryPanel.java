package userInterface;

import gameWorld.Drawable;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author Rudi Theunissen
 */
public class InventoryPanel extends CustomComponent {
	private ArrayList<String> itemList = new ArrayList<String>();
	private ArrayList<String> weaponList = new ArrayList<String>();
	private final int width = 100;
	private final int height = 100;
	private int itemAcross = 100;

    public InventoryPanel() {
        setPreferredSize(new Dimension(0, 100));
    }

    public void paintContent(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        g.drawRect(0, 0, getWidth()-1, getHeight()-1);
        g.setStroke(new BasicStroke());
        for(int i=0; i<=5; i++){
        	g.drawLine(i*100, 0, i*100, getHeight());
        }
        weaponList.add("images/baseballbat.png");
        if(weaponList.size() >1){
        	for(int e = 0; e<weaponList.size(); e++){

            	String image = weaponList.get(e);
            	Icon weapon = new Icon(0, 0, 100, 100, image);
            }
        }
        if(itemList.size() >1){
        	for(int f = 0; f<itemList.size(); f++){
            	
            }
        }
        
        itemAcross = 0;
    }
    
    public void addItem(String imagePath){
    	itemList.add(imagePath);
    }
    
    public void addWeapon(String imagePath){
    	weaponList.add(imagePath);
    	
    }
}
