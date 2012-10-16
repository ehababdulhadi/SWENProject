package gameWorld;

/** Represents a Zombie (Enemy). A Zombie can carry an item and the player need to carry a weapon to kill one. 
 * Some Zombies requires a special type of weapons to be killed. Ex: The boss Zombie will need to be killed with a Bazooka! **/



public class Zombie extends RoomComponentContainer{
	
	

	public Zombie(double x, double y, double w, double h, String imagePath) {
		super(x, y, w, h, imagePath);
		// TODO Auto-generated constructor stub
	}
	
	private String enemy_name;
	
}
