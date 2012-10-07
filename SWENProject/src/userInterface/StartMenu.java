package userInterface;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class StartMenu extends CustomComponent{
    
    private final Font mainFont = new Font(Font.SANS_SERIF, Font.PLAIN, 40);
    
    public StartMenu(){
        this.setLayout(new FlowLayout());
        JButton start = new JButton("Start");
        start.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               //
                MainGameWindow.switchToRoom(0);
            }
            
        });
        
        this.add(start);
    }
    
    
    public void paintContent(Graphics2D g){
        
        g.setFont(mainFont);
        g.setColor(Color.BLACK);
        g.drawString("Main Menu", 100, 100);
        
    }

}
