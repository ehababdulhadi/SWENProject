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
		
		/** Here we'll need to get arguments in the command-line to decide what type of game is it: Multi-Player/Single-Player **/
		
		// Show the game's start menu //
		new StartMenu(); // The 'startAnewGame' should be called from the Start Menu //
	} 
	
	/** Start a new Single Player  game **/
	public static void startAnewGame(){
		// Initialize the game and create all required objects //
		GameState game = new GameState();
		
		//Start the application window
		mainGameWindow =  new MainGameWindow();
		
	}
	
	public static void endGame(){
		//ends the game
		System.exit(0);
		
	}
	
	
	

}
