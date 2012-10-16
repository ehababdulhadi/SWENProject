package userInterface;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import userInterface.CustomComponent;
import userInterface.ResourceLoader;

public class Icon extends CustomComponent{

    public final BufferedImage image;
    private final String imagePath;
    public final int x, y, w, h;
    
    
    public Icon(int x, int y, int w, int h, String imagePath){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.imagePath = imagePath;
        image = ResourceLoader.openImage(imagePath);
    }
    
    @Override
    public void paintContent(Graphics2D g) {
        if(image != null) g.drawImage(image, x, y, w, h, null);
    }
    
    public String toString(){
        return "Drawable[imagePath=" + imagePath + "]";
    }
    
    public String getImage(){
    	return this.imagePath;
    }
}
