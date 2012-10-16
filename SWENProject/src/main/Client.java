package main;

import java.net.Socket;

import javax.swing.JOptionPane;

public class Client extends NetworkThread {

    public void run() {
        String ipAddress = JOptionPane.showInputDialog("Enter an IP to connect to");

        try {
            socket = new Socket(ipAddress, PORT);
            System.err.println("Connected to " + ipAddress + " on port " + Server.PORT);
            listen();
        } catch (Exception nfe) {
            System.err.println("Exception in connection thread.\n" + nfe);
        }
    }
}
