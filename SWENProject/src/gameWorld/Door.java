package gameWorld;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import userInterface.CustomComponent;
import userInterface.MainGameWindow;
import userInterface.Message;


public class Door extends CustomComponent {
/** Represents a Door. Links between 2 rooms, could be locked and need a specific type of key to open. **/
//	private Room room1;
//	private Room room2;
    private String doorKey;
    private int destination;
    private int orientation;

    public Door(int destination, int orientation) {
        this.destination = destination;
        this.orientation = orientation;
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }


    @Override
    public void onMouseClick(MouseEvent e) {
        System.err.println("Door clicked");
        System.err.println("Is door unlocked? " + GameState.LOCKS[destination]);
        System.err.println("Switching to Room: " + destination);
        if (!isLocked()) MainGameWindow.switchToRoom(destination);
        else {
            Message.show("This door is locked and requires the " + Key.getKey(destination) + " key to unlock it.");
        }
    }

    public void paintContent(Graphics2D g) {
        g.setColor(Color.BLACK);

        g.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        g.drawString(destination + "", getWidth() / 2, getHeight() / 2);
        
        int w = getWidth();
        int h = getHeight();
        
        int p = (3 * h / 4) / 4; // perspective ratio

        switch (orientation) {
            case 0: // back wall
                g.drawRect(0, 0, w - 1, h);
                break;
            case 1: // left wall
                g.drawLine(0, p, 0, h);
                g.drawLine(0, p, w - 1, 0);
                g.drawLine(w - 1, 0, w - 1, h - p);
                break;
            case 2: // right wall
                g.drawLine(0, 0, 0, h - p);
                g.drawLine(0, 0, w - 1, p);
                g.drawLine(w - 1, p, w - 1, h);
                break;

        }
    }

    public String toString() {
        return "Door[dest=" + destination + "]";
    }

    public int getDestination() {
        return destination;
    }

    public boolean isLocked() {
        return !GameState.LOCKS[destination];
    }

    public String getDoorKey() {
        return doorKey;
    }

    public void setDoorKey(String doorKey) {
        this.doorKey = doorKey;
    }
}
