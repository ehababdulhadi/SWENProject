package gameWorld;

import javax.swing.ImageIcon;

import userInterface.MainGameWindow;

/** This enum has all types of objects the player could carry or drop.
 * 
 */
public enum ObjectType {
	KEY("keyimage"),
	WEAPON("keyimage"),
	LOCATION_FEATURE(null);
	
	private String imagePath;
	
	private ObjectType(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public ImageIcon getImage() { 
		return MainGameWindow.makeImageIcon(imagePath);
	}
}
