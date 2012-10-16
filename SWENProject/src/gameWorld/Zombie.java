package gameWorld;

/** Represents a Zombie (Enemy). A Zombie can carry an item and the player need to carry a weapon to kill one. 
 * Some Zombies requires a special type of weapons to be killed. Ex: The boss Zombie will need to be killed with a Bazooka! **/



public class Zombie extends RoomComponentContainer{
	
	

	public Zombie(double x, double y, double w, double h, String imagePath) {
		super(x, y, w, h, imagePath);
		// TODO Auto-generated constructor stub
	}
	
	private String enemy_name;
	/*private String enemy_name;
>>>>>>> 2ff26f3c2a3a5ab064e0eb8856185a92e6ea3b74
	private RoomComponent itemCarriedByZombie;
=======
	 public void addItem(Drawable drawable){
	        contents.add(drawable);
	    }
	/*private String enemy_name;
	private Drawable itemCarriedByZombie;
>>>>>>> 2ff26f3c2a3a5ab064e0eb8856185a92e6ea3b74
	private Room roomOfZombie;
	private ImageIcon zombieImage;
	private boolean isBoss = false;
	
	public final BufferedImage image;
	private final String imagePath;
    public final double x, y, w, h; 
	
	public Zombie (String name, Room room, ImageIcon image){
		
		this.enemy_name = name;
		this.roomOfZombie = room;
		this.zombieImage = image;
	}
	
public Zombie (double x, double y, double w, double h, String imagePath) {
		
	this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.imagePath = imagePath;
    image = ResourceLoader.openImage(imagePath);
	}

	public String toString(){
    return "Zombie[imagePath=" + imagePath + "]";
	}

	@Override
	public void paintContent(Graphics2D g) {
    if(image != null) g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
	
	*//**
	 * Is called if this enemy is attacked by a player
	 * Works out the damage allocated and removes it from the enemies health
	 *//*
	public void receiveHit(int damage){ 
		this.setLife(getLife()-damage);
		if (isDead()){
			*//** change enemy's image to dead **//*
			}			
		}

	private void setLife(int i) {
		// TODO Auto-generated method stub
		
	}
	
	private void getLife(int i) {
		// TODO Auto-generated method stub
		
	}

	private int getLife() {
		// TODO Auto-generated method stub
		return 0;
	}

	private boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getEnemy_name() {
		return enemy_name;
	}
	

	public int getCurrentFrame() {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean isBeingAttacked() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getFrameWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getFrameHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

<<<<<<< HEAD
	public RoomComponent getItemCarriedByZombie() {
		return itemCarriedByZombie;
	}

	public void setItemCarriedByZombie(RoomComponent itemCarriedByZombie) {
=======
	public Drawable getItemCarriedByZombie() {
		return itemCarriedByZombie;
	}

	public void setItemCarriedByZombie(Drawable itemCarriedByZombie) {
>>>>>>> 2ff26f3c2a3a5ab064e0eb8856185a92e6ea3b74
		this.itemCarriedByZombie = itemCarriedByZombie;
	}

	public Room getRoomOfZombie() {
		return roomOfZombie;
	}

	public void setRoomOfZombie(Room roomOfZombie) {
		this.roomOfZombie = roomOfZombie;
	}

	public boolean getIsBoss() {
		return isBoss;
	}

	public void setIsBoss(boolean isBoss) {
		this.isBoss = isBoss;
	}	*/
}
