package gameWorld;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import userInterface.CustomComponent;

/**
 * <<<<<<< HEAD Represents a Room, which can contain a Player, Zombie, RoomComponent and Doors ======= Represents a Room, which can contain a Player, Zombie, Drawable and Doors >>>>>>>
 * 2ff26f3c2a3a5ab064e0eb8856185a92e6ea3b74
 *
 */
public class Room extends CustomComponent {

    private String roomName;
    private ImageIcon roomBackground;
    private ArrayList<Player> playersInTheRoom = new ArrayList<Player>();
    private Zombie zombieOfTheRoom = null;
    private boolean hasZombie = false;
    private ArrayList<Door> doorsOfTheRoom = new ArrayList<Door>();
    Random randomGenerator = new Random();
    private Rectangle backWall;
    private Door[] doors;
    private ArrayList<RoomComponent> items = new ArrayList<RoomComponent>();

    public Room(int... destinations) {
//		this.roomName = name;
//		this.roomBackground = background;
        //this.setItemsOfTheRoom(drawables);
        //this.playersInTheRoom = players;
        //this.zombieOfTheRoom = zombie;
        //this.doorsOfTheRoom = doors;
        /*
         * if (!(zombie == null)) this.hasZombie = true; *
         */

        doors = new Door[destinations.length];
        for (int i = 0; i < doors.length; i++) {
            doors[i] = new Door(destinations[i], i);
            this.add(doors[i]);
        }

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("KEY PRESSED: " + KeyEvent.getKeyText(e.getKeyCode()));
                GameState.sendToNetwork(e.getKeyCode());
            }
        });

    }

    public void paintContent(Graphics2D g) {
        int w = getWidth();
        int h = getHeight();

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, w, h);

        g.setColor(Color.BLACK);

        int xFactor = 5;
        int yFactor = 3;

        g.setColor(Color.BLACK);

        backWall = new Rectangle(w / xFactor, -1, w - w / xFactor * 2, h - h / yFactor + 1);

        g.drawLine(0, backWall.y + backWall.height + h / yFactor / 2, backWall.x, backWall.y + backWall.height);
        g.drawLine(w, backWall.y + backWall.height + h / yFactor / 2, backWall.x + backWall.width, backWall.y + backWall.height);

        g.draw(backWall);

        int doorWidth = w / 8;
        int doorHeight = h / 3;

        int pc = doorWidth / 4; // perspective correction


        for (int i = 0; i < doors.length; i++) {
            if (i == 0) doors[0].setBounds(backWall.x + backWall.width / 2 - doorWidth / 2, backWall.y + backWall.height - doorHeight, doorWidth, doorHeight);
            else if (i == 1) doors[1].setBounds(w / 4 / 2 - doorWidth / 2 - pc / 2, backWall.y + backWall.height - doorHeight + doorHeight / 8, doorWidth - pc, doorHeight + doorHeight / 4);
            else if (i == 2) doors[2].setBounds(w - w / 4 / 2 - pc / 2, backWall.y + backWall.height - doorHeight + doorHeight / 8, doorWidth - pc, doorHeight + doorHeight / 4);
        }

        for (RoomComponent drawable : items) {

            int iw, ih;

            if (drawable.image == null) return;

            double imageRatio = (double) drawable.image.getWidth() / drawable.image.getHeight();
            double componentRatio = (drawable.w * w) / (drawable.h * h);

            if (imageRatio > componentRatio) { // 
                iw = (int) (drawable.w * w);
                ih = (int) (iw / imageRatio);
            } else {
                ih = (int) (drawable.h * h);
                iw = (int) (imageRatio * ih);
            }

            drawable.setBounds((int) (drawable.x * getWidth()), (int) (drawable.y * getHeight()) - ih, iw, ih);

        }

        // Drawing the Zombies (if there is one!)  //
        if (this.getZombie() != null)
            this.getZombie().setBounds((int) (this.getZombie().x * getWidth()), (int) (this.getZombie().y * getHeight()) - 2, 100, 20);
    }

    public void addItem(RoomComponent item) {
        items.add(item);
        this.add(item);
        repaint();
    }

    public void removeItem(RoomComponent item) {
        items.remove(item);
        this.remove(item);
        repaint();
    }

//     private MouseAdapter mouse = new MouseAdapter() {
//
//        @Override
//        public void mouseEntered(MouseEvent e) {
//            mouseOver = true;
//            repaint();
//        }
//
//        public void mouseExited(MouseEvent e) {
//            mouseOver = false;
//            repaint();
//        }
//
//        public void mouseReleased(MouseEvent e) {
//            if (Door.this.contains(e.getPoint())) onMouseClick(e);
//        }
//    };
//
//    public void onMouseClick(MouseEvent e) {
//        System.err.println("Door clicked");
//        System.err.println("Switching to Room: " + destination);
//        RoomTemplate.ROOM_SWITCHER.switchTo(destination);
//    }
    public String getLocation_name() {
        return roomName;
    }

    public ArrayList<Player> getPlayers_in_location_ArrayList() {
        return playersInTheRoom;
    }

    public Zombie getZombie() {
        return zombieOfTheRoom;
    }

    public void setZombie(Zombie zombie) {
        this.zombieOfTheRoom = zombie;
    }

    public boolean isHasZombie() {
        return hasZombie;
    }

    public void setHasZombie(boolean hasZombie) {
        this.hasZombie = hasZombie;
    }

    public ArrayList<Door> getDoorsOfTheRoom() {
        return doorsOfTheRoom;
    }

    public void setDoorsOfTheRoom(ArrayList<Door> doorsOfTheRoom) {
        this.doorsOfTheRoom = doorsOfTheRoom;
    }

    public ArrayList<RoomComponent> getItemsOfTheRoom() {
        return items;
    }

    public void setItemsOfTheRoom(ArrayList<RoomComponent> itemsOfTheRoom) {
        this.items = itemsOfTheRoom;
    }
}
