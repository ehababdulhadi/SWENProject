package gameWorld;

import java.util.Random;

/** Represents a weapon. **/
public class Weapon{

	private int damageDealt;
	private Random rng = new Random(3);
	
    public Weapon(int damageDealt) {
        this.damageDealt = damageDealt;
    }

    public int getDamageDealt(){
    		return rng.nextInt(damageDealt);
    }

}
