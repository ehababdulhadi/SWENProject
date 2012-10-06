package gameWorld;

import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GameState {
	
	// TODO Auto-generated method stub
			// Game's Locations
			public Room  room1;
			public Room  room2;
			public Room  room3;
			public Room  room4;
			public Room  room5;
			public Room  room6;

			/** Rendering Team: Add the root of the images files for each room. Use only 1 if you'll use 1 image to all rooms **/
			// Background Images' Roots // 
			final String room1Background1ImageRoot = "";
			final String room2Background2ImageRoot = "";
			final String room3Background3ImageRoot = "";
			final String room4Background4ImageRoot = "";
			final String room5Background5ImageRoot = "";
			final String room6Background6ImageRoot = "";

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
			 
			
			public GameState (){
				initializeGame();	
			}

	public void initializeGame() {
		
		// Creating the locations //
		createRooms();
		
		// Creating the locations //
		fillRooms();
		
		/** Display the game window starting from Room 1, render the items in the room and listen to mouse clicks **/
	
	}

	private void fillRooms() {
		
		ImageIcon tempImage = new ImageIcon(); /** This will need to be replaced later with the right image to each item in the game **/
		
		// Fill Room 1 //
		ArrayList<Item> items = new ArrayList<Item>();
		// Create a box and the Bronze Key in Room 1. Put the key "inside" the box! //
		Item box = new Item("Box", "You need a 4 digit pin to open this box!", room1, tempImage);
		box.setIsBox(true); // Declaring this Item as a box that contains other items //
		Item bronzeKey = new Item ("Bronze Key", "Bronze Key!", room1, tempImage);
		box.getBoxItems().add(bronzeKey);
		box.boxSetLocked(true); // Lock the box! //
		// Create the silver Key and Note //
		Item silverKey = new Item("Silver Key", "Silver Key!", room1, tempImage);
		silverKey.setHidden(true);
		Item noteOfRoom1 = new Item("note1", "Tell the Game Story to Player", room1, tempImage);
		// Add all items to Room 1 //
		room1.getItemsOfTheRoom().addAll(items);
		
		// Fill Room 2 //
		Item gun = new Item("Gun", "A Gun! Could be used to kill avarage sized zombies!", room2, tempImage);
		
		// Fill Room 3 //
		Item room1BoxCodeNumber = new Item("Code of Box in Room 1", "1234!", room3, tempImage);
		Zombie room3Zombie = new Zombie("Room3 Zombie", room3, tempImage);
		room3Zombie.setItemCarriedByZombie(room1BoxCodeNumber);
		
		// Fill Room 4 //
		Item silverKeyNote = new Item("Silver Key Note", "Silver Key is Hidden in Room 1 behind the brick!", room4, tempImage);
		Zombie room4Zombie = new Zombie("Room4 Zombie", room4, tempImage);
		room4Zombie.setItemCarriedByZombie(silverKeyNote);
		
		// Fill Room 5 //
		Item goldenKey = new Item("Golden Key", "Golden Key!", room5, tempImage);
		Zombie room5Zombie = new Zombie("Room5 Zombie", room5, tempImage);
		room5Zombie.setItemCarriedByZombie(goldenKey);
		
		// Fill Room 6 //
		Item bazooka = new Item("Bazooka", "Bazooka!!", room6, tempImage);
		
	}

	/** This method is better to be moved to another class later (Board/GameWindow/GameState?). Main should be only used to run the game **/
	private void createRooms() {
		
		ImageIcon tempImage = new ImageIcon(); /** This will need to be replaced later with the right image to each item in the game **/
		
		// Create Room1 //
		room1 = new Room ("Room 1", tempImage, "Room 1");
	
		// Create Room2 //
		room2 = new Room ("room2", tempImage, "Room 2");
		
		// Create Room3 //
		room3 = new Room ("room3", tempImage, "Room 3");
			
		// Create Room4 //
		room4 = new Room ("room4", tempImage, "Room 4");
		
		// Create Room5 //
		room5 = new Room ("room5", tempImage, "Room 5");
		
		// Create Room6 //
		room6 = new Room ("room6", tempImage, "Room 6");
		
	}
	
}
