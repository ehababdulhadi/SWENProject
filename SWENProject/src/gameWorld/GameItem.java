package gameWorld;

import java.awt.Image;
import java.util.Map;

import javax.swing.ImageIcon;

import userInterface.Drawable;

/** This class helps to create the objects in the game such as; keys, Trees ...etc
 * 
 */
public class GameItem implements Drawable {
	private int x;
	private int y;
	private int frameWidth;
	private int frameHeight;
	private ObjectType type;
	private boolean carryable;
	
	private Image objectImage;
	
	private String description;
	
	public GameItem(int x, int y, ImageIcon objectImage, String description, ObjectType type, boolean carryable) {

		this.x = x;
		this.y = y;
		// this.image = image; //
		this.objectImage = objectImage.getImage();
		
		this.frameWidth = objectImage.getIconWidth();
		this.frameHeight = objectImage.getIconHeight();
		this.setDescription(description);

		this.type = type;
		this.carryable = carryable;

	}

	public ObjectType getType() { return type; }

	@Override
	public int getPosX() {
		return x;
	}

	@Override
	public int getPosY() {
		return y;
	}

	@Override
	public void setPosX(int posX) {
		x = posX;
	}

	@Override
	public void setPosY(int posY) {
		y = posY;		
	}

	@Override
	public Image getImage() {
		return objectImage;
	}

	@Override
	public int getFrameWidth() {
		return frameWidth;
	}

	@Override
	public int getFrameHeight() {
		return frameHeight;
	} 


	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	
	public boolean getCarryable() {
		return carryable;
	}

	@Override
	public int getCurrentFrame() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isBeingAttacked() {
		// TODO Auto-generated method stub
		return false;
	}


}