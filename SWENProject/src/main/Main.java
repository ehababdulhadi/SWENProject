package main;

/** The Main class. Will addInventory and end a game. **/
import gameWorld.GameState;
import userInterface.MainGameWindow;


public class Main {

	/** Fields **/
	private static MainGameWindow mainGameWindow;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
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
