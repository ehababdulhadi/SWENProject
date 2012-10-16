package gameWorld;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.border.LineBorder;
import userInterface.CustomComponent;
import userInterface.ResourceLoader;

public class Drawable extends CustomComponent{

    public final BufferedImage image;
    private final String imagePath;
    public final double x, y, w, h;
    
    private ArrayList<Drawable> contents = new ArrayList<Drawable>();
	
    public Drawable(double x, double y, double w, double h, String imagePath){
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.imagePath = imagePath;
        image = ResourceLoader.openImage(imagePath);
        //this.setBorder(new LineBorder(Color.RED));
    }
    
    public void addItem(Drawable drawable){
        contents.add(drawable);
    }
    
    @Override
    public void paintContent(Graphics2D g) {
        if(image != null) g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
    }
    
    public String toString(){
        return "Drawable[imagePath=" + imagePath + "]";
    }
}
