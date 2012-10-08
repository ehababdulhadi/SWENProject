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
		int port = 32768; // default
		String url = null;	
		boolean isServer = false;
		
		for (int i = 0; i != args.length; ++i) {
			if (args[i].startsWith("-")) {
				String arg = args[i];
				if(arg.equals("-server")) {
					isServer = true;
				} else if(arg.equals("-connect")) {
					url = args[++i];
				}
			}else{
				System.out.println("You need to use -server or -connect hostname to start/join a game");
				endGame();
			}
			
			if(isServer){
				url = "localhost";
				Server server = new Server(port);
				server.start();
			}
		}
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
