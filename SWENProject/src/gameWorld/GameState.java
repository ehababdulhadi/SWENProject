package gameWorld;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import main.Client;
import main.NetworkThread;
import main.NetworkType;
import main.Server;
import userInterface.MainGameWindow;
import userInterface.Message;

/**
 * A class to keep track of (and update) the status of the game (Players, Enemies, Items and Progress). *
 */
public class GameState {

    public static final int NUMBER_OF_ROOMS = 6;
    public static Room[] ROOMS = new Room[NUMBER_OF_ROOMS];
    public static boolean[] LOCKS = new boolean[NUMBER_OF_ROOMS];
    private static NetworkThread network;
    private static Player player = new Player("Player", new ArrayList<RoomComponent>(), null, null);

    static {
        // unlock initial doors
        LOCKS[0] = true;
        LOCKS[1] = true;
        LOCKS[2] = true;
    }
    
    public static void onRoomEntry(Room room) {
        // Here?
    }

    public static void createNetworkThread(NetworkType type) {

        switch (type) {
            case SERVER:
                network = new Server() {

                    public void read(int data) {
                        readFromNetwork(data);
                    }
                };
                break;
            case CLIENT:
                network = new Client() {

                    public void read(int data) {
                        readFromNetwork(data);
                    }
                };
                break;
        }
        network.start();
    }

    public static void readFromNetwork(int data) {
        System.out.println("Read from network: " + data);
        switch (data) {
            case 100:
                bronzeChest.removeItems();
                LOCKS[3] = true;
                break;
            case 101:
                ROOMS[0].removeItem(silverKey);
                break;
            case 102:
                break;
            case 103:
                ROOMS[0].removeItem(note3);
                break;
            case 104:
                ROOMS[1].removeItem(baseballBat);
                break;
            case 105:
                ROOMS[5].removeItem(gun);
                break;

        }
    }

    public static void sendToNetwork(int data) {
        if (network != null) network.send(data);
    }

    public static void setNetworkThread(NetworkThread network) {
    }



    public GameState() {
        initializeGame();
    }

    public void initializeGame() {

        // Creating the Rooms //
        createRooms();

        // Creating the Rooms //
        fillRooms();

        /**
         * Display the game window starting from Room 1, render the items in the room and listen to mouse clicks *
         */
    }

    private void createRooms() {

        // Create Room1 //
        ROOMS[0] = new Room(1);

        // Create Room2 //
        ROOMS[1] = new Room(0, 2, 5);

        // Create Room3 //
        ROOMS[2] = new Room(1, 3);

        // Create Room4 //
        ROOMS[3] = new Room(2, 4);

        // Create Room5 //
        ROOMS[4] = new Room(3);

        // Create Room6 //
        ROOMS[5] = new Room(1, 6);

    }
    private static RoomComponentContainer bronzeChest;
    private static RoomComponent bronzeKey;
    private static RoomComponent silverKey;
    private static RoomComponent goldKey;
    private static RoomComponent baseballBat;
    private static RoomComponent gun;
    private static Note note3;
    private static RoomComponent bricks;
    private static RoomComponentContainer zombie1;
    private static RoomComponentContainer zombie2;
    private static RoomComponentContainer zombie3;

    private void fillRooms() {


        bronzeChest = new RoomComponentContainer(0.20, 0.8, 0.20, 0.20, "images/safe.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                System.err.println("Bronze chest was clicked");
                if (this.getContents().size() == 0) {
                    Message.show("This chest has already been opened and contains no items");
                } else {
                    String input = JOptionPane.showInputDialog("What is the combination?");
                    int c = 0;
                    try {
                        c = Integer.parseInt(input);
                    } catch (Exception ex) {
                    }
                    if (c == 1234) {
                        Message.show("Correct! You now have the bronze key");
                        player.addItems(this.getContents());
                        this.removeItems();
                        LOCKS[3] = true;
                        sendToNetwork(100);
                    } else {
                        Message.show("Sorry that was incorrect.");
                    }
                }
            }
        };



        bronzeKey = new RoomComponent(0.7, 0.8, 0.2, 0.2, "images/key_bronze.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                System.err.println("Bronze key was clicked");
            }
        };

        silverKey = new RoomComponent(0.81, 0.79, 0.3, 0.3, "images/silverkey.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                ROOMS[0].removeItem(this);
                LOCKS[5] = true;
                sendToNetwork(101);
                Message.show("You found a silver key!");
            }
        };

        goldKey = new RoomComponent(0.5, 0.5, 0.1, 0.1, "images/goldkey.png") {

            public void onMouseClick(MouseEvent e) {
                sendToNetwork(102);
            }
        };

        String message3 = "Page 3: I'm the last one left";
        note3 = new Note(0.8, 0.8, 0.1, 0.1, "images/note-paper.png", message3) {

            @Override
            public void onMouseClick(MouseEvent e) {
                ROOMS[0].removeItem(this);
                sendToNetwork(103);
                Message.show("You picked up a note! It says:\n" + this.getMessage());
            }
        };

        baseballBat = new RoomComponent(0.7, 0.85, 0.2, 0.2, "images/baseballbat.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                player.setWeapon(new Weapon(20));
                ROOMS[1].removeItem(this);
                MainGameWindow.getInventory().addItem(this);
                sendToNetwork(104);
                Message.show("You have found a baseball bat. This could help defending against enemies");
            }
        };

        // Ehab - Trying Zombies //
        zombie1 = new RoomComponentContainer(0.6, 0.8, 0.6, 0.6, "images/brick.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                System.out.println("Zombie1 Clicked!");
            }
        };





        zombie2 = new RoomComponentContainer(0.6, 0.8, 0.2, 0.6, "images/brick.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                System.out.println("Zombie2 Clicked!");
            }
        };

        zombie3 = new RoomComponentContainer(0.6, 0.8, 0.2, 0.6, "images/brick.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                System.out.println("Zombie3 Clicked!");
            }
        };

        gun = new RoomComponent(0.2, 0.85, 0.2, 0.2, "images/gun.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                player.setWeapon(new Weapon(50));
                ROOMS[5].removeItem(this);
                sendToNetwork(105);
                Message.show("You have found a gun. You feel safer.");
            }
        };

        bricks = new RoomComponent(0.6, 0.3, 0.2, 0.2, "images/brick.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                if (!player.hasZombieTooth()) {
                    sendToNetwork(106);
                    Message.show("Wow...bricks...though one of them is slightly loose but you can't seem to pry it out");
                    player.aquireTooth();
                } else {
                    Message.show("You use your zombie tooth to pry a loose brick free. You find a silver key");
                    ROOMS[0].removeItem(silverKey);
                    LOCKS[5] = true;
                    player.addItem(silverKey);
                    sendToNetwork(101);
                }
            }
        };

        zombie1.addItem(note3);
        zombie2.addItem(note3);
        zombie3.addItem(goldKey);
        bronzeChest.addItem(bronzeKey);

        ROOMS[0].addItem(bronzeChest);
        ROOMS[0].addItem(note3);
        ROOMS[0].addItem(bricks);
        ROOMS[1].addItem(baseballBat);
        ROOMS[5].addItem(gun);














//                // Fill Room 1 //
//		ArrayList<Item> items = new ArrayList<Item>();
//		// Create a box and the Bronze Key in Room 1. Put the key "inside" the box! //
//		RoomComponent box = new RoomComponent("Box", "You need a 4 digit pin to open this box!", ROOMS[0], tempImage);
//		box.setIsBox(true); // Declaring this RoomComponent as a box that contains other items //
//		RoomComponent bronzeKey = new RoomComponent ("Bronze Key", "Bronze Key!", ROOMS[0], tempImage);
//		box.getBoxItems().add(bronzeKey);
//		box.boxSetLocked(true); // Lock the box! //
//		// Create the silver Key and Note //
//		RoomComponent silverKey = new RoomComponent("Silver Key", "Silver Key!", ROOMS[0], tempImage);
//		silverKey.setHidden(true);
//		RoomComponent noteOfRoom1 = new RoomComponent("note1", "Tell the Game Story to Player", ROOMS[0], tempImage);
//		// Add all items to Room 1 //
//		ROOMS[0].getItemsOfTheRoom().addAll(items);
//		
//		// Fill Room 2 //
//		RoomComponent gun = new RoomComponent("Gun", "A Gun! Could be used to kill avarage sized zombies!", ROOMS[1], tempImage);
//		
//		// Fill Room 3 //
//		RoomComponent room1BoxCodeNumber = new RoomComponent("Code of Box in Room 1", "1234!",  ROOMS[2], tempImage);
//		Zombie room3Zombie = new Zombie("Room3 Zombie", ROOMS[2], tempImage);
//		room3Zombie.setItemCarriedByZombie(room1BoxCodeNumber);
//		
//		// Fill Room 4 //
//		RoomComponent silverKeyNote = new RoomComponent("Silver Key Note", "Silver Key is Hidden in Room 1 behind the brick!", ROOMS[3], tempImage);
//		Zombie room4Zombie = new Zombie("Room4 Zombie", ROOMS[3], tempImage);
//		room4Zombie.setItemCarriedByZombie(silverKeyNote);
//		
//		// Fill Room 5 //
//		RoomComponent goldenKey = new RoomComponent("Golden Key", "Golden Key!", ROOMS[4], tempImage);
//		Zombie room5Zombie = new Zombie("Room5 Zombie", ROOMS[4], tempImage);
//		room5Zombie.setItemCarriedByZombie(goldenKey);
//		
//		// Fill Room 6 //
//		RoomComponent bazooka = new RoomComponent("Bazooka", "Bazooka!!", ROOMS[5], tempImage);

        // Add Zombies //
        ROOMS[3].addItem(zombie1);
        ROOMS[4].addItem(zombie2);
        ROOMS[5].addItem(zombie3);



    }
}
