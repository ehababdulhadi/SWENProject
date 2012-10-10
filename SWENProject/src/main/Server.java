package main;

import java.net.ServerSocket;

public class Server extends NetworkThread{

    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.err.println("Waiting for a client to connect.");
            socket = serverSocket.accept();
            System.err.println("Accepted connection on port " + PORT);
            listen();
        } catch (Exception e) {
            System.err.println("Exception in server thread.\n" + e);
        }
    }

}