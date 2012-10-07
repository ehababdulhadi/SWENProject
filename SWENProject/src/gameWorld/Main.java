package gameWorld;


import userInterface.MainGameWindow;


public class Main {

	/** Fields **/
	private static MainGameWindow mainGameWindow;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/** Here we'll need to get arguments in the command-line to decide what type of game is it: Multi-Player/Single-Player **/
		
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
