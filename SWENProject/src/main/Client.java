package main;

import java.net.Socket;

public class Client extends NetworkThread {

    public void run() {
        String ipAddress = "localhost";

        try {
            socket = new Socket(ipAddress, PORT);
            System.err.println("Connected to " + ipAddress + " on port " + Server.PORT);
            listen();
        } catch (Exception nfe) {
            System.err.println("Exception in connection thread.\n" + nfe);
        }
    }
}
