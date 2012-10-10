/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author PARANOID
 */
public abstract class NetworkThread extends Thread{
    
    public static final int PORT = 1234;
    public InputStream in;
    public OutputStream out;
    public Socket socket;

    public void listen() throws Exception {
        in = new DataInputStream(socket.getInputStream());
        out = new DataOutputStream(socket.getOutputStream());
        new Thread() {
            @Override
            public void run() {
                int data;
                try {
                    while ((data = in.read()) != -1) {
                        read(data);
                    }
                } catch (IOException ex) {
                  
                }

            }
        }.start();
    }


    public void read(int data) {
         System.out.println("Client receives: " + data);
    }
    // send an int through the socket


    public void send(int data){
        System.err.println("Client writing: " + data);
        try {
            if(out != null) out.write(data);
        } catch (IOException ex) {
          
        }
    }
    
}
