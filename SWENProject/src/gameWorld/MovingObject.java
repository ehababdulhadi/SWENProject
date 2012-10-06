package gameWorld;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import userInterface.Drawable;

/**
 * This class is used as a base class for the enemy and 
 * player classes and contains functionality that is common
 * to both.
 *
 */
public abstract class MovingObject implements Drawable {
	private String name;
	private int life;	
	private int posX;
	private int posY;
	private ArrayList<GameItem> items = new ArrayList<GameItem>();

	private boolean isMoving = false;
	private boolean isAttacking = false;
	private int attackCounter = 0;
	private int receivedHitCounter = 0;
	private Room room;
	private int attackPower;

	private int attackLength;
	private int receivedHitMaxTime;
	private Image image;


	public MovingObject(String name, int life, int posX, int posY, int moveTotalFrames,
			int atkStartFrame, int atkStopFrame, int deathFrame,
			int frameSizeX, int frameSizeY, int attackLength,
			int attackedMaxTime, int attackPower, Room room, Image image, 
			int actualPosXOffset, int actualWidth) {
		
		this.setName(name);
		this.life = life;
		this.posX = posX;
		this.posY = posY;
		this.attackLength = attackLength;
		this.receivedHitMaxTime = attackedMaxTime;
		this.attackPower = attackPower;
		this.setLocation(room);
		this.image = image;
		
	}

	public MovingObject() {};

	@Override public int getPosX() { return posX; }

	@Override public void setPosX(int posX) {
		if (!isDead()) {
			// Do something! //
		}
	}

	@Override public int getPosY() { return posY; }

	@Override public void setPosY(int posY) {
		if (!isDead()) {
			// Do something! //
		}
	}

	@Override public Image getImage() {
		return image;
	}

	public void setLife(int life) { 
		if (!isDead()) {
			if (life <= 0) life = 0;
			this.life = life;
			receivedHitCounter(receivedHitMaxTime);
		}
		else if (life > 0) {
			this.life = life;
		}

	}

	/** 
	 * A player is regarded as dead when their life points reach 0 
	 */
	public boolean isDead() {
		return life <= 0;
	}

	/**
	 * This method is called whenever the moving object is attacked.
	 * 
	 * @param damage the amount of life to remove from the moving object.
	 */
	public abstract void receiveHit (int damage);

	/**
	 * A helper method for determining if a drawable is within range
	 * of the player
	 * 
	 * @param d the drawable to check
	 * @param rangeX the max allowable distance of the drawable in the x direction from the player 
	 * 			(note that the width of the object is also taken into account) 
	 * @param rangeY the max allowable distance of the drawable in the y direction from the player
	 * 			(doesn't take the height of the object into account, just checks the bottom values
	 * 			of the images)
	 * @param checkDirection if true, the current direction of the player will be taken into account
	 * @return true if the drawable is within range of the player
	 */
	public boolean isInRange(Drawable d, int rangeX, int rangeY, boolean checkDirection) {
		return checkDirection;
	}

	protected boolean isAttacking() {
		return isAttacking;
	}

	protected void setAttacking(boolean isAttacking) {
		this.isAttacking = isAttacking;
		
	}

	protected int getAttackCounter() {
		return attackCounter;
	}

	protected void setAttackCounter(int attackCounter) {
		this.attackCounter = attackCounter;

	}

	protected int getReceivedHitCounter() {
		return receivedHitCounter;
	}

	private void receivedHitCounter(int attackedCounter) {
		this.receivedHitCounter = attackedCounter;

	}

	public int getLife() {
		return life;
	}

	public Room getLocation() {
		return room;
	}

	public void setLocation(Room room) {
		this.room = room;
	}

	public int getAttackPower() {
		return attackPower;
	}

	public void setAttackPower(int attackPower) {
		this.attackPower = attackPower;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<GameItem> getItems() {
		return items;
	}

	public boolean isBeingAttacked() {
		// TODO Auto-generated method stub
		return false;
	}

}
