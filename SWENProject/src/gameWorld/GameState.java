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
            case 200:
                ROOMS[2].removeItem(zombie1);
                break;
            case 300:
                ROOMS[3].removeItem(zombie2);
                break;
            case 400:
                ROOMS[5].removeItem(zombie3);
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
    private static RoomComponent fang;
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
                    if (c == 1337) {
                        Message.show("Correct! You now have the bronze key");
                        player.addItems(this.getContents());
                        this.removeItems();
                        LOCKS[3] = true;
                        MainGameWindow.getInventory().addItem(bronzeKey);
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
                MainGameWindow.getInventory().addItem(this);
                Message.show("You found a silver key!");
            }
        };

        goldKey = new RoomComponent(0.5, 0.5, 0.1, 0.1, "images/goldkey.png") {


            public void onMouseClick(MouseEvent e) {
                MainGameWindow.getInventory().addItem(this);
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

        fang = new RoomComponent(0.7, 0.85, 0.2, 0.2, "images/Fang.png") ;
            
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
        zombie1 = new RoomComponentContainer(0.6, 0.8, 0.6, 0.6, "images/zombie1.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                System.out.println("Zombie1 Clicked!");
                this.setHealth(this.getHealth()-player.useWeapon());
                if(this.isDead()){
                    ROOMS[2].removeItem(this);
                    sendToNetwork(200);
                    Message.show("You killed the zombie! It drops a note that with a 4 digit code on it. 1337");
                }
            }
        };





        zombie2 = new RoomComponentContainer(0.6, 0.8, 0.2, 0.6, "images/zombie2.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                System.out.println("Zombie2 Clicked!");
                System.out.println("Zombie1 Clicked!");
                this.setHealth(this.getHealth()-player.useWeapon());
                if(this.isDead()){
                    ROOMS[3].removeItem(this);
                    MainGameWindow.getInventory().addItem(fang);
                    player.aquireTooth();
                    sendToNetwork(300);
                    Message.show("You killed the zombie! You rip out a tooth and save it for later");
                }
            }
        };

        zombie3 = new RoomComponentContainer(0.6, 0.8, 0.2, 0.6, "images/zombie3.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                System.out.println("Zombie3 Clicked!");
                System.out.println("Zombie1 Clicked!");
                this.setHealth(this.getHealth()-player.useWeapon());
                if(this.isDead()){
                    ROOMS[5].removeItem(this);
                    sendToNetwork(400);
                       MainGameWindow.getInventory().addItem(goldKey);  
                       LOCKS[4] = true;
                    Message.show("You killed the zombie! He was holding a golden key. You pick it up");
                }
            }
        };

        gun = new RoomComponent(0.2, 0.85, 0.2, 0.2, "images/gun.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                player.setWeapon(new Weapon(50));
                ROOMS[5].removeItem(this);
                sendToNetwork(105);
                MainGameWindow.getInventory().addItem(this);
                Message.show("You have found a gun. You feel safer.");
            }
        };

        bricks = new RoomComponent(0.6, 0.3, 0.2, 0.2, "images/brick.png") {

            @Override
            public void onMouseClick(MouseEvent e) {
                if (!player.hasZombieTooth()) {
                    sendToNetwork(106);
                    Message.show("Wow...bricks...though one of them is slightly loose but you can't seem to pry it out");
                } else {
                    Message.show("You use your zombie tooth to pry a loose brick free. You find a silver key");
                    ROOMS[0].removeItem(silverKey);
                    LOCKS[5] = true;
                    player.addItem(silverKey);
                    MainGameWindow.getInventory().addItem(silverKey);
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

        // Add Zombies //
        ROOMS[2].addItem(zombie1);
        ROOMS[3].addItem(zombie2);
        ROOMS[5].addItem(zombie3);

    }
}