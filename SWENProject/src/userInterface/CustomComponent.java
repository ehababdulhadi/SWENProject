package userInterface;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;

/**
 *
 * @author Rudi Theunissen
 */
public class CustomComponent extends JComponent{
    
    public CustomComponent(){
        this.addMouseListener(new MouseAdapter() {

        @Override
        public void mouseEntered(MouseEvent e) {
            onMouseEntered(e);
        }

        public void mouseExited(MouseEvent e) {
             onMouseExited(e);
        }

        public void mouseReleased(MouseEvent e) {
            if (CustomComponent.this.contains(e.getPoint())) onMouseClick(e);
        }
    });
    }

    public void onMouseEntered(MouseEvent e){}
    public void onMouseExited(MouseEvent e){}
    public void onMouseClick(MouseEvent e) {}
    
    public void paintContent(Graphics2D g){
        super.paintComponent(g);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        paintContent(g);
    }
}
