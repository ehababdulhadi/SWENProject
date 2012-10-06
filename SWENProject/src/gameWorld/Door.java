package gameWorld;

public class Door {
	
	private Room room1;
	private Room room2;
	private boolean isLocked;
	private String doorKey;
	
	public Door (Room room, Room otherRoom, boolean locked, String keyName){
		
		this.setRoom1(room);
		this.setRoom2(otherRoom);
		this.setLocked(locked);
		this.setDoorKey(keyName);
	}

	public Room getRoom1() {
		return room1;
	}

	public void setRoom1(Room room1) {
		this.room1 = room1;
	}

	public Room getRoom2() {
		return room2;
	}

	public void setRoom2(Room room2) {
		this.room2 = room2;
	}

	public boolean isLocked() {
		return isLocked;
	}

	public void setLocked(boolean isLocked) {
		this.isLocked = isLocked;
	}

	public String getDoorKey() {
		return doorKey;
	}

	public void setDoorKey(String doorKey) {
		this.doorKey = doorKey;
	}

}
