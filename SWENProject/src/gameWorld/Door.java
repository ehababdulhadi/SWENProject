package gameWorld;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import userInterface.CustomComponent;
import userInterface.MainGameWindow;
import userInterface.Message;

/** Represents a Door. Links between 2 rooms, could be locked and need a specific type of key to open. **/
public class Door extends CustomComponent{
	
//	private Room room1;
//	private Room room2;
	private boolean isLocked;
	private String doorKey;
        
    private boolean mouseOver;
    private int destination;
	
	public Door (int destination){
            
        this.destination = destination;
		this.isLocked = isLocked;
		this.doorKey = doorKey;
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
        
    
     public void onMouseEntered(MouseEvent e){
            mouseOver = true;
            repaint();
     }
    
     public void onMouseExited(MouseEvent e) {
        mouseOver = false;
        repaint();
    }


    @Override
    public void onMouseClick(MouseEvent e) {
        System.err.println("Door clicked");
        System.err.println("Is door unlocked? " + GameState.LOCKS[destination]);
        System.err.println("Switching to Room: " + destination);
        if(GameState.LOCKS[destination])MainGameWindow.switchToRoom(destination);
        else{
            Message.show("This door is locked and requires the " + Key.getKey(destination) + " key to unlock it.");
        }
    }

    public void paintContent(Graphics2D g) {
        g.setColor(Color.BLACK);
        
        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        g.drawString(destination + "", getWidth() / 2, getHeight() / 2);
        
        AffineTransform at = new AffineTransform();
        
        at.shear(0.0, -0.5);
        
      //  g.setTransform(at);
        
     //   if (mouseOver) g.fillRect(0, 0, getWidth(), getHeight());
        // else
         g.drawRect(0, 0, getWidth() - 1, getHeight());
    }

    public String toString() {
        return "Door[dest=" + destination + "]";
    }

//	public Room getRoom1() {
//		return room1;
//	}
//
//	public void setRoom1(Room room1) {
//		this.room1 = room1;
//	}
//
//	public Room getRoom2() {
//		return room2;
//	}
//
//	public void setRoom2(Room room2) {
//		this.room2 = room2;
//	}
        
        public int getDestination(){
            return destination;
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
