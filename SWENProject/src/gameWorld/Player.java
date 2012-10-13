package gameWorld;


import java.util.ArrayList;

public class Player {
	
	String playerName;
	private int livesRemaining = 3;
	private ArrayList<Item> playerItems = new ArrayList<Item>();
	private Room playerRoom;
	private Room previousRoom;
	
	public Player(String name, ArrayList<Item> items, Room room, Room prevRoom){
		
		this.playerName = name;
		this.playerItems = items;
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

	public ArrayList<Item> getPlayerItems() {
		return playerItems;
	}

	public void setPlayerItems(ArrayList<Item> playerItems) {
		this.playerItems = playerItems;
	}

	public Room getPlayerRoom() {
		return playerRoom;
	}

	public void setPlayerRoom(Room playerRoom) {
		this.playerRoom = playerRoom;
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

