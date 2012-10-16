package userInterface;

import gameWorld.GameState;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.JButton;

import main.NetworkType;

public class StartMenu extends CustomComponent {

    private final Font mainFont = new Font(Font.SANS_SERIF, Font.BOLD, 72);
    BufferedImage zombie1 = ResourceLoader.openImage("images/zombie_yellow_right.png");
    BufferedImage zombie2 = ResourceLoader.openImage("images/zombie_blue_right.png");
    BufferedImage player = ResourceLoader.openImage("images/player.png");
    MenuButton host = new MenuButton("Host");
    MenuButton join = new MenuButton("Join");

    public StartMenu() {
        this.setLayout(null);

        this.add(host);
        this.add(join);

        ActionListener al = new ActionListener() {

            
            public void actionPerformed(ActionEvent e) {
                Object src = e.getSource();
                if (src == host) {
                   
                    // this person will be hosting, currently over localhost only
                    GameState.createNetworkThread(NetworkType.SERVER);
                    MainGameWindow.switchToRoom(0);
                     MainGameWindow.addInventory();
                } else {
                    
                    // this person will be joining, currently over localhost only
                    GameState.createNetworkThread(NetworkType.CLIENT);
                    MainGameWindow.switchToRoom(0);
                    MainGameWindow.addInventory();
                }
            }
        };
        
        host.addActionListener(al);
        join.addActionListener(al);
    }


    public void paintContent(Graphics2D g) {
        
        g.setColor(Color.BLACK);
        g.fillRect(0,0,getWidth(),getHeight());
    	
    g.setFont(mainFont);
    g.setColor(Color.RED);
    
            int w = getWidth();
        int h = getHeight();
    
    int sw = g.getFontMetrics().stringWidth("Zombie Adventure");
    
    g.drawString("Zombie Adventure", w / 2 - sw / 2, 100);
        


    	host.setBounds(w / 2 - 100, h / 2 - 50, 200, 50);
        join.setBounds(w / 2 - 100, h / 2 + 50, 200, 50);
        
        
                 g.drawImage(zombie2, 150, h - zombie2.getHeight() - 50, null);
        g.drawImage(zombie1, 50, h - zombie1.getHeight() - 20, null);

          g.drawImage(player, w - player.getWidth() - 100, h - player.getHeight() - 50, null);
    }
    
    private class MenuButton extends JButton{
        
        public MenuButton(String text){
            super(text);
            this.setBorderPainted(false);
            this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 32));
            this.setForeground(Color.RED);
            this.setBackground(Color.BLACK);
            this.setContentAreaFilled(false);
            this.setFocusPainted(false);
        }
    }
}
