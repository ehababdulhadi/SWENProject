package userInterface;

import gameWorld.GameState;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.*;

/**
 * The application window for holding menus and the rendering window.
 *
 */
public class MainGameWindow extends JFrame {

    private static final ViewSwitcher switcher = new ViewSwitcher();
    private static final InventoryPanel inventory = new InventoryPanel();
    
    private static Container content;
    
    public static void switchToRoom(int room){
        switcher.switchTo(room % GameState.ROOMS.length);
    }
    
    public static void addInventory(){
       content.add(inventory, BorderLayout.SOUTH);
    }

    public MainGameWindow() {
        
        content = getContentPane();
        

        switcher.setHost(content);
        
        switcher.registerView(new StartMenu(), "Menu");
     
        
        for(int i = 0; i < GameState.ROOMS.length; i++){
            switcher.registerView(GameState.ROOMS[i], i);
        }

        switcher.switchTo("Menu");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(1000, 600));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }
    
    public static InventoryPanel getInventory(){
        return inventory;
    }
}
