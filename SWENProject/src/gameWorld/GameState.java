package gameWorld;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import userInterface.Message;

public class GameState {
    
  public static final int NUMBER_OF_ROOMS = 6;
    
    public static Room [] ROOMS = new Room [NUMBER_OF_ROOMS];
    public static boolean [] LOCKS = new boolean [NUMBER_OF_ROOMS];
    
    static{
        
        // unlock initial doors
        LOCKS[0] = true;
        LOCKS[1] = true;
        LOCKS[2] = true;
        
        
    }
	
	// TODO Auto-generated method stub
			// Game's Locations
			//public Room  room1;
			//public  Room  room2;
			//public  Room  room3;
			//public Room  room4;
			//public  Room  room5;
			//public Room  room6;
			//public static Room safety;

			/** Rendering Team: Add the root of the images files for each room. Use only 1 if you'll use 1 image to all ROOMS **/
			// Background Images' Roots // 
//			final String room1Background1ImageRoot = "";
//			final String room2Background2ImageRoot = "";
//			final String room3Background3ImageRoot = "";
//			final String room4Background4ImageRoot = "";
//			final String room5Background5ImageRoot = "";
//			final String room6Background6ImageRoot = "";

//			/** Rendering Team: Add the root of the images files for each item **/
//			// Stationary Objects Images' Roots //
//			final String goldenKeyImageRoot = "";
//			final String silverKeyImageRoot = "";
//			final String bronzeKeyImageRoot = "";
//			final String gunImageRoot = "";
//			final String bazookaImageRoot = "";
//			final String boxImageRoot = "";
//			final String noteImageRoot = "";
//			final String brikImageRoot = "";
//
//			/** Rendering Team: Add the root of the images files for each Zombie **/
//			final String zombieImageRoot = "";
//			final String bossZombieImageRoot = "";
//			final String deadZomabieImageRoot = "";
			 
			
			public GameState (){
				initializeGame();	
			}

	public void initializeGame() {
		
		// Creating the Rooms //
		createRooms();
		
		// Add doors to ROOMS //
		addDoorsToRooms();
		
		// Creating the Rooms //
		fillRooms();
		
		/** Display the game window starting from Room 1, render the items in the room and listen to mouse clicks **/
	
	}

	private void addDoorsToRooms() {
		
		// Create Doors //
//		Door door1 = new Door(1, false, "");
//		Door door2 = new Door(5, true, "Silver Key");
//		Door door3 = new Door(2, false, "");
//		Door door4 = new Door(3, true, "Bronze Key");
//		Door door5 = new Door(4, false, "Silver Key");
//		Door door6 = new Door(6, true, "Golden Key"); // Final Exit: Player Win The Game //
//			
//		// Add Doors to Rooms //
//		ROOMS[0].getDoorsOfTheRoom().add(door1);
//		ROOMS[1].getDoorsOfTheRoom().add(door1);
//		ROOMS[1].getDoorsOfTheRoom().add(door2);
//		ROOMS[1].getDoorsOfTheRoom().add(door3);
//		ROOMS[2].getDoorsOfTheRoom().add(door3);
//		ROOMS[2].getDoorsOfTheRoom().add(door4);
//		ROOMS[3].getDoorsOfTheRoom().add(door4);
//		ROOMS[3].getDoorsOfTheRoom().add(door5);
//		ROOMS[4].getDoorsOfTheRoom().add(door5);
//		ROOMS[5].getDoorsOfTheRoom().add(door2);
//		ROOMS[5].getDoorsOfTheRoom().add(door6);
	}

    private void fillRooms() {

        ImageIcon tempImage = new ImageIcon();
        /**
         * This will need to be replaced later with the right image to each item in the game *
         */
        Chest bronzeChest = new Chest(0.25, 0.6, 0.2, 0.2, "images/safe.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                 System.err.println("Bronze chest was clicked");
                 String input = JOptionPane.showInputDialog("What is the combination?");
                 int c = 0;
                 try{
                     c = Integer.parseInt(input);
                 } catch (Exception ex){
                     
                 }
                if (c == 1234) {
                    Message.show("Correct! You now have the bronze key");
                } else {
                    Message.show("Sorry that was incorrect.");
                }
            }
        };

        Item bronzeKey = new Item(0.7, 0.8, 0.075, 0.1,  "images/key_bronze.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                System.err.println("Bronze key was clicked");
            }
        };


        Item silverKey = new Item(0.5, 0.5,  0.1, 0.1, "images/key_silver.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
            }
        };

        Item goldKey = new Item(0.5, 0.5,  0.1, 0.1, "images/key_gold.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
            }
        };
        
        bronzeChest.addItem(bronzeKey);
        
        
        
        ROOMS[0].addItem(bronzeChest);
        ROOMS[0].addItem(bronzeKey);

        


                
                
                
                
                
                
                
                
                
                
                
                
//                // Fill Room 1 //
//		ArrayList<Item> items = new ArrayList<Item>();
//		// Create a box and the Bronze Key in Room 1. Put the key "inside" the box! //
//		Item box = new Item("Box", "You need a 4 digit pin to open this box!", ROOMS[0], tempImage);
//		box.setIsBox(true); // Declaring this Item as a box that contains other items //
//		Item bronzeKey = new Item ("Bronze Key", "Bronze Key!", ROOMS[0], tempImage);
//		box.getBoxItems().add(bronzeKey);
//		box.boxSetLocked(true); // Lock the box! //
//		// Create the silver Key and Note //
//		Item silverKey = new Item("Silver Key", "Silver Key!", ROOMS[0], tempImage);
//		silverKey.setHidden(true);
//		Item noteOfRoom1 = new Item("note1", "Tell the Game Story to Player", ROOMS[0], tempImage);
//		// Add all items to Room 1 //
//		ROOMS[0].getItemsOfTheRoom().addAll(items);
//		
//		// Fill Room 2 //
//		Item gun = new Item("Gun", "A Gun! Could be used to kill avarage sized zombies!", ROOMS[1], tempImage);
//		
//		// Fill Room 3 //
//		Item room1BoxCodeNumber = new Item("Code of Box in Room 1", "1234!",  ROOMS[2], tempImage);
//		Zombie room3Zombie = new Zombie("Room3 Zombie", ROOMS[2], tempImage);
//		room3Zombie.setItemCarriedByZombie(room1BoxCodeNumber);
//		
//		// Fill Room 4 //
//		Item silverKeyNote = new Item("Silver Key Note", "Silver Key is Hidden in Room 1 behind the brick!", ROOMS[3], tempImage);
//		Zombie room4Zombie = new Zombie("Room4 Zombie", ROOMS[3], tempImage);
//		room4Zombie.setItemCarriedByZombie(silverKeyNote);
//		
//		// Fill Room 5 //
//		Item goldenKey = new Item("Golden Key", "Golden Key!", ROOMS[4], tempImage);
//		Zombie room5Zombie = new Zombie("Room5 Zombie", ROOMS[4], tempImage);
//		room5Zombie.setItemCarriedByZombie(goldenKey);
//		
//		// Fill Room 6 //
//		Item bazooka = new Item("Bazooka", "Bazooka!!", ROOMS[5], tempImage);

		
	}
        
        

	/** This method is better to be moved to another class later (Board/GameWindow/GameState?). Main should be only used to run the game **/
	private void createRooms() {
		
		// Create Room1 //
		ROOMS[0] = new Room (1);
	
		// Create Room2 //
		ROOMS[1] = new Room (0, 2, 5);
		
		// Create Room3 //
		ROOMS[2] = new Room (1, 3);
			
		// Create Room4 //
		ROOMS[3] = new Room (2, 4);
		
		// Create Room5 //
		ROOMS[4] = new Room (3);
		
		// Create Room6 //
		ROOMS[5] = new Room (1, 6);

                
		// Create Room7: Safety! //
		//safety = new Room ("safety", tempImage, "Door to Safety and Freedom!");
	}
	
}
