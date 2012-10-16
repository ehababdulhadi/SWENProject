package gameWorld;

public class Note extends Drawable{
	
	private String message;
	
	/** Represents a Note. just a piece of text to inform the player with info or update about the game. **/
    public Note(double x, double y, double w, double h, String imagePath, String message) {
        super(x, y, w, h, imagePath);
        this.message = message;
    }

    public String getMessage(){
    		return message;
    }

}
