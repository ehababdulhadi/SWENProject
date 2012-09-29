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
		// Show the game's start menu //
		new StartMenu();
	} 
	
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
	
	private static void initializeGame() {
		// TODO Auto-generated method stub
		// Game's Locations
		Location  location1;
		Location  location2;
		Location  location3;
		Location  location4;
		Location  location5;
		Location  location6;

		// Background Images' Roots //
		final String background1ImageRoot = "";
		final String background2ImageRoot = "";
		final String background3ImageRoot = "";
		final String background4ImageRoot = "";
		final String background5ImageRoot = "";
		final String background6ImageRoot = "";

		// Stationary Objects Images' Roots //
		final String object1ImageRoot = "";
		final String object2ImageRoot = "";
		final String object3ImageRoot = "";
		final String object4ImageRoot = "";

		// Enemy Images' Roots  //
		final String enemy1ImageRoot = "";
		final String enemy2ImageRoot = "";
		final String enemy3ImageRoot = "";
		final String enemy4ImageRoot = "";

		// Player Image's Root
		final String playerImageRoot = "";

		// Creating the locations //
		
		// Ad item to each location (Random?)//
		
		// Setting left Locations for each location
		
		// Setting right locations for each location
		
		
	}

	

}
