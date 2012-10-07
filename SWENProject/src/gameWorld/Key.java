package gameWorld;

/**
 *
 * @author Rudi Theunissen
 */
public enum Key {

    BRONZE(3),
    SILVER(5),
    GOLD(6);
   
    public final int door;
    
    public static Key getKey(int destination){
        for(Key key : Key.values()){
            if(key.door == destination) return key;
        }
        return null;
    }

    private Key(int door) {
        this.door = door;
    }
}
