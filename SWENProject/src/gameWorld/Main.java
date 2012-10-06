package gameWorld;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import userInterface.MainGameWindow;
import userInterface.StartMenu;


public class Main {

	/** Fields **/
	private static MainGameWindow mainGameWindow;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/** Here we'll need to get arguments in the commandline to decide what type of game is it: Multi-Player/Single-Player **/
		
		// Show the game's start menu //
		new StartMenu();
	} 
	
	/** Start a new Single Player  game **/
	public static void startAnewGame(){
		// Initialize the game and create all required objects //
		initializeGame();
		
		//Start the application window
		mainGameWindow =  new MainGameWindow();
		
	}
	
	public static void endGame(){
		//ends the game
		System.exit(0);
		
	}
	
	public static void initializeGame() {
		// TODO Auto-generated method stub
		// Game's Locations
		Room  room1;
		Room  room2;
		Room  room3;
		Room  room4;
		Room  room5;
		Room  room6;

		/** Rendering Team: Add the root of the images files for each room. Use only 1 if you'll use 1 image to all rooms **/
		// Background Images' Roots // 
		final String background1ImageRoot = "";
		final String background2ImageRoot = "";
		final String background3ImageRoot = "";
		final String background4ImageRoot = "";
		final String background5ImageRoot = "";
		final String background6ImageRoot = "";

		/** Rendering Team: Add the root of the images files for each item **/
		// Stationary Objects Images' Roots //
		final String goldenKeyImageRoot = "";
		final String silverKeyImageRoot = "";
		final String bronzeKeyImageRoot = "";
		final String gunImageRoot = "";
		final String bazookaImageRoot = "";
		final String boxImageRoot = "";
		final String noteImageRoot = "";
		final String brikImageRoot = "";

		/** Rendering Team: Add the root of the images files for each Zombie **/
		final String zombieImageRoot = "";
		final String bossZombieImageRoot = "";
		final String deadZomabieImageRoot = "";
		
		// Creating the locations //
		createRooms();
		
		// Add items of each location //
		addItemsToEachRoom();
		
	}

	/** This method is better to be moved to another class later (Board/GameWindow?). Main should be only used to run the game **/
	private static void createRooms() {
	
		Zombie zombie1 = new Zombie(null, 0, 0, 0, 0, null, 0, 0, 0);
		
		ImageIcon tempImage = new ImageIcon();
		
		// Create Room1 //
		Room room1 = new Room ("room1", tempImage, "Room 1");
		// Create Room2 //
		Room room2 = new Room ("room2", tempImage, "Room 2");
		// Create Room3 //
		Room room3 = new Room ("room3", tempImage, "Room 3");
		// Create Room4 //
		Room room4 = new Room ("room4", tempImage, "Room 4");
		// Create Room5 //
		Room room5 = new Room ("room5", tempImage, "Room 5");
		// Create Room6 //
		Room room6 = new Room ("room6", tempImage, "Room 6");
	}
	
	/** This method is better to be moved to another class later (Board/GameWindow?). Main should be only used to run the game **/
	private static void addItemsToEachRoom() {
	
		
	}
	

}
