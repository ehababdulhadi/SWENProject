package gameWorld;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import userInterface.MainGameWindow;

/**
 * A player is a moving object which a person can control
 * @author 
 *
 */
public class Player extends MovingObject{
	private int player_score = 0;

	int livesRemaining = 3;


	/**
	 * Constructs a player and sets a bunch of parameters as follows
	 * @param owner the gamestate which controls the player
	 * @param name the name of the player
	 * @param location the current location of the player
	 * @param x the width of the players image
	 * @param y the height of the players image
	 * @param life the life points of the player
	 * @param image the image associated to the player
	 */
	public Player(String name, Location location, int x, int y, int life, Image image){

		
	}

	/**
	 * Perform an 'attack' command. If an enemy is detected
	 * in range, the player will attack the enemy 
	 */
	public void attack() {
		int rangeX = 50;
		int rangeY = 10;
		setAttacking(true);


		List<Enemy> enemies = getLocation().getEnemiesList();
		// Loop thought the enemies of this location and check if the player's sword is touching any of them //
		for (int i=0; i< enemies.size(); i++){
			Enemy e = enemies.get(i);
			// if the sword is touching the enemy then call a hit method on the enemy //
			if (!e.isDead() && isInRange(e, rangeY, rangeX, true)) {
				e.receiveHit(getAttackPower());

				/* if the attack resulted in the death of an enemy, add some points to 
				 * the players score */
				if(e.isDead()) setPlayer_score(player_score + e.getPoints());
			}
		}
	}

	/**
	 * This method is called whenever the player tries to interact
	 * with their environment.
	 */
	public void interact() {
		pickUpObject();
	}

	/** This method will allow a player to get information about objects. When a player press ( I ) on an object 
	 * a window will pop up with a description about that object.
	 */
	public void lookAt() {
		for (int i = 0; i < getLocation().getObjects_in_location_ArrayList().size(); i++){

			if (isInRange(getLocation().getObjects_in_location_ArrayList().get(i), 0, 20, false)){
				String title = "Information!";
				String text = getLocation().getObjects_in_location_ArrayList().get(i).getDescription();
				// display info about the item on the screen //
			}
		}
	}

	/**
	 * This method checks if there are any keys within range of the player.
	 * If there are, they are picked up and added to the players list of keys.
	 */
	private void pickUpObject() {
		List<GameItem> objects = getLocation().getCarryableObjects();

		for (GameItem s : objects) {
			if (isInRange(s, 50, 50, false)) {
				// Check what type of item it is and act accordingly //
			}
		}
	}


	public void setPlayer_score(int player_score) {
		this.player_score = player_score;
	}

	public int getPlayer_score() {
		return player_score;
	}

	public void setPlayer_Life(int player_Life) {
		super.setLife(player_Life);
	}

	@Override public void setPosX(int posX) {
		super.setPosX(posX);
	}

	@Override public void setPosY(int posY) {
		super.setPosY(posY);
	}

	/**
	 * This method is called whenever the player is attacked.
	 * 
	 * @param damage the amount of life to remove from the player.
	 */
	public void receiveHit(int damage){ 
		
	}

	public int getLivesRemaining() { return livesRemaining; }

	@Override
	public int getCurrentFrame() {
		// TODO Auto-generated method stub
		return 0;
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

