package userInterface;

import gameWorld.RoomComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;


/**
 *
 * @author Rudi Theunissen
 */
public class InventoryPanel extends CustomComponent {
	
    public InventoryPanel() {
        setPreferredSize(new Dimension(0, 50));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
    }

    public void addItem(RoomComponent item) {
        item.setPreferredSize(new Dimension(50, 50));
        this.add(item);
        validate();
    }

    public void removeItem(RoomComponent item) {
        this.remove(item);
        validate();
    }

    public void paintContent(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintContent(g);
    }
}
