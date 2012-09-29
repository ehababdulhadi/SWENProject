package userInterface;

import java.awt.Image;

/**
 * All objects need to implement this interface in order for the GUI to draw them
 */
public interface Drawable {
	/**
	 * @return the bottom left x-coordinate of the objects position
	 */
	public int getPosX();
	
	/**
	 * @return the bottom left y-coordinate of the objects position
	 */
	public int getPosY();
	
	/**
	 * @param posX the bottom left x-coordinate of the objects position
	 */
	public void setPosX(int posX);
	
	/**
	 * @param posY the bottom left y-coordinate of the objects position
	 */
	public void setPosY(int posY);
	
	/**
	 * @return the image to draw on screen
	 */
	public Image getImage();
	
	/**
	 * @return the width of one frame of the image
	 */
	public int getFrameWidth();
	
	/**
	 * @return the height of one frame of the image
	 */
	public int getFrameHeight();
	
	/**
	 * @return the direction the object is facing. this is always set to DOWN
	 * if the object is always stationary.
	 */
	
	/**
	 * @return the frame to draw (for an animated object). this is always set
	 * to 0 if the object is not animated.
	 */
	public int getCurrentFrame();

	boolean isBeingAttacked();
	
	
}
