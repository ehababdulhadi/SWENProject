package gameWorld;


import java.util.ArrayList;

/** Represents a game player. Hold all sort of Player's info, including name, lives, health, items carried... etc **/
public class Player {
	
	String playerName;
	private int livesRemaining = 3;

	private ArrayList<RoomComponent> playerItems = new ArrayList<RoomComponent>();

	private Room playerRoom;
	private Room previousRoom;
	private Weapon weapon = new Weapon(5); //Fists

	public Player(String name, ArrayList<RoomComponent> drawables, Room room, Room prevRoom){	
		this.playerName = name;
		this.playerItems = drawables;
		this.playerRoom = room;
		this.previousRoom = prevRoom;
		
	}

	public Room getPreviousRoom() {
		return previousRoom;
	}

	public void setPreviousRoom(Room previousRoom) {
		this.previousRoom = previousRoom;
	}

	public int getLivesRemaining() {
		return livesRemaining;
	}

	public void setLivesRemaining(int livesRemaining) {
		this.livesRemaining = livesRemaining;
	}


	public ArrayList<RoomComponent> getPlayerItems() {
		return playerItems;
	}

	public void setPlayerItems(ArrayList<RoomComponent> playerItems) {
		this.playerItems = playerItems;
	}
	

	public void addItem(RoomComponent item){
		this.playerItems.add(item);
	}
	
	public void addItems(ArrayList<RoomComponent> items){
		this.playerItems.addAll(items);
        }


	public Room getPlayerRoom() {
		return playerRoom;
	}

	public void setPlayerRoom(Room playerRoom) {
		this.playerRoom = playerRoom;
	}

	public void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	
	public int useWeapon(){
		return weapon.getDamageDealt();
	}
	
    public void receiveHit(int damage) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getFrameWidth() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getFrameHeight() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public int getCurrentFrame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean isBeingAttacked() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

	
}

