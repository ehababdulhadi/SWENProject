package gameWorld;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import userInterface.MainGameWindow;

public class Player {
	
	String playerName;
	private int livesRemaining = 3;
	private ArrayList<Item> playerItems = new ArrayList<Item>();
	private Room playerRoom;
	private Room previousRoom;
	
	public Player(String name, Room room, int x, int y, int life, Image image){
		
	}

	public Room getPreviousRoom() {
		return previousRoom;
	}

	public void setPreviousRoom(Room previousRoom) {
		this.previousRoom = previousRoom;
	}

	public int getLivesRemaining() {
		return livesRemaining;
	}

	public void setLivesRemaining(int livesRemaining) {
		this.livesRemaining = livesRemaining;
	}

	public ArrayList<Item> getPlayerItems() {
		return playerItems;
	}

	public void setPlayerItems(ArrayList<Item> playerItems) {
		this.playerItems = playerItems;
	}

	public Room getPlayerRoom() {
		return playerRoom;
	}

	public void setPlayerRoom(Room playerRoom) {
		this.playerRoom = playerRoom;
	}

	
}

