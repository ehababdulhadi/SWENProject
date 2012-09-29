package gameWorld;

import java.awt.Image;
import java.util.Map;
import java.util.Random;

public class Enemy extends MovingObject  {
	
	private String enemy_name;
	private int targetDestX = 0;
	private int targetDestY = 0;
	private int targetCounter = 0;
	private int moveSpeed;
	
	private int points; // the number of points the player receives when they kill this enemy
		
	private Random random = new Random();
	
	/**
	 * Constructs a new Enemy
	 * @param owner the gamestate associated with this enemy
	 * @param location the current location of the enemy
	 * @param xPosition the current x position
	 * @param yPosition the current y position
	 * @param life the health points of the enemy
	 * @param attackPower how strong the enemy is
	 * @param image the image for this enemy
	 * @param width the images width
	 * @param height the images height
	 * @param move the amount of time between each movement
	 */
	public Enemy (Location location, int xPosition, int yPosition, int life, int attackPower, Image image, int width, int height, int move){
		
		moveSpeed = random.nextInt(attackPower*10) + 5;
		if(moveSpeed > 50)
			moveSpeed = 50; //sets a max speed
		
		points = attackPower * life;		
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
		
	/** 
	 * @return The number of points 
	 */
	public int getPoints() { return points; }
	
	/**
	 * Moves the enemy randomly around the location
	 */
	/* for now, move the enemy randomly */
	public void move() {
		if (!isDead()) {
			boolean playerFound = false;
			/* first check if any players in range  if attack counter == 0 */
			if (!isAttacking()) {
				for (Player p : getLocation().getPlayers_in_location_ArrayList()) {
					if (isInRange(p, 25, 10, true)) {
						/* a player is in range, attack them */
						p.receiveHit(getAttackPower());
						playerFound = true;
						setAttacking(true);
						break;
					}
				}
			}
			
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
}
