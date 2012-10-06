package gameWorld;

import java.awt.Image;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;

public class Zombie extends MovingObject  {
	
	private String enemy_name;
	private Item itemCarriedByZombie;
	private Room roomOfZombie;
	private ImageIcon zombieImage;
	private boolean isBoss = false;
	
	public Zombie (String name, Room room, ImageIcon image){
		
		this.enemy_name = name;
		this.roomOfZombie = room;
		this.zombieImage = image;
	}
	
	/**
	 * Is called if this enemy is attacked by a player
	 * Works out the damage allocated and removes it from the enemies health
	 */
	public void receiveHit(int damage){ 
		this.setLife(getLife()-damage);
		if (isDead()){
			/** change enemy's image to dead **/
			}			
		}

	public String getEnemy_name() {
		return enemy_name;
	}
	
	@Override public void setLife(int life) {
		super.setLife(life);
	}

	@Override 
	public void setPosX(int posX) {
		super.setPosX(posX);
	}

	@Override 
	public void setPosY(int posY) {
		super.setPosY(posY);
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

	@Override
	public int getFrameWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getFrameHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Item getItemCarriedByZombie() {
		return itemCarriedByZombie;
	}

	public void setItemCarriedByZombie(Item itemCarriedByZombie) {
		this.itemCarriedByZombie = itemCarriedByZombie;
	}

	public Room getRoomOfZombie() {
		return roomOfZombie;
	}

	public void setRoomOfZombie(Room roomOfZombie) {
		this.roomOfZombie = roomOfZombie;
	}

	public boolean getIsBoss() {
		return isBoss;
	}

	public void setIsBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}	
}
