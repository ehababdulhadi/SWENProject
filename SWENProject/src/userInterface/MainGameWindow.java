package userInterface;

import gameWorld.GameState;
import java.awt.Dimension;

import javax.swing.*;

/**
 * The application window for holding menus and the rendering window.
 *
 */
public class MainGameWindow extends JFrame {

    public static final ViewSwitcher ROOM_SWITCHER = new ViewSwitcher();
    
    public static void switchToRoom(int room){
        ROOM_SWITCHER.switchTo(room % GameState.ROOMS.length);
    }

    public MainGameWindow() {

        ROOM_SWITCHER.setHost(getContentPane());
        
        ROOM_SWITCHER.registerView(new StartMenu(), -1);
        
        for(int i = 0; i < GameState.ROOMS.length; i++){
            ROOM_SWITCHER.registerView(GameState.ROOMS[i], i);
        }

        ROOM_SWITCHER.switchTo(-1);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 500));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
}
