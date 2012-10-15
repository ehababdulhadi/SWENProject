package gameWorld;

public class Note extends Item{
	
	private String message;
	
    public Note(double x, double y, double w, double h, String imagePath, String message) {
        super(x, y, w, h, imagePath);
        this.message = message;
    }

    public String getMessage(){
    		return message;
    }

}
