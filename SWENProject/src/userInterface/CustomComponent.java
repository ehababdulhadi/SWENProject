package userInterface;

import java.awt.Graphics;
import java.awt.Graphics2D;
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
        
    }
    
    @Override
    public void paintComponent(Graphics graphics){
        Graphics2D g = (Graphics2D) graphics;
        GraphicsUtils.enableHighQuality(g);
        GraphicsUtils.enableBilinearInterpolation(g);
        paintContent(g);
    }

}
