package userInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

/**
 *
 * @author Rudi Theunissen
 */
public class InventoryPanel extends CustomComponent {

    public InventoryPanel() {
        setPreferredSize(new Dimension(0, 50));
    }

    public void paintContent(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        
        g.setColor(Color.WHITE);
        g.drawString("Inventory Panel", 50, 30);
    }
}
