package userInterface;

import gameWorld.GameState;
import gameWorld.RoomComponent;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import main.Client;
import main.NetworkType;
import main.Server;

public class StartMenu extends CustomComponent {

    private final Font mainFont = new Font(Font.SANS_SERIF, Font.PLAIN, 40);

    public StartMenu() {
        this.setLayout(new FlowLayout());
        JButton host = new JButton("Host Game");
        JButton join = new JButton("Join Game");
        BufferedImage image = ResourceLoader.openImage("images/mainScreen.png");
        host.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // this person will be hosting, currently over localhost only
                GameState.createNetworkThread(NetworkType.SERVER);

                MainGameWindow.switchToRoom(0);
            }
        });

        join.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // this person will be joining, currently over localhost only
                GameState.createNetworkThread(NetworkType.CLIENT);

                MainGameWindow.switchToRoom(0);
            }
        });

        this.add(host);
        this.add(join);
    }

    public void paintContent(Graphics2D g) {
    	BufferedImage image = ResourceLoader.openImage("images/mainScreen.png");
    	g.drawImage(image, 0, 0, 1000, 550, null);
    	g.setColor(Color.WHITE);
    	Rectangle rec1 = new Rectangle(100,100,100,100){

			public void onMouseClick(MouseEvent e){
                System.err.println("Bronze key was clicked");
            }
    	};
    	g.draw(rec1);
    }
}
