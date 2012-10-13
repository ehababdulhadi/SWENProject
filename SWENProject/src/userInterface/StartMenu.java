package userInterface;

import gameWorld.GameState;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        g.setFont(mainFont);
        g.setColor(Color.BLACK);
        g.drawString("Main Menu", 100, 100);

    }
}
