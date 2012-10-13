package gameWorld;


import javax.swing.ImageIcon;

public class Zombie   {
	
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

	private void setLife(int i) {
		// TODO Auto-generated method stub
		
	}
	
	private void getLife(int i) {
		// TODO Auto-generated method stub
		
	}

	private int getLife() {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getEnemy_name() {
		return enemy_name;
	}
	

	public int getCurrentFrame() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isBeingAttacked() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getFrameWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

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
