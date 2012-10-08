package gameWorld;

import java.io.*;
import java.net.*;

public class Server extends Thread{
	
	private int port;
	
	public Server(int port){
		this.port = port;
	}
	
   public void run(){

         ServerSocket welcomeSocket;
         System.out.println("Server is running");
		try {
			welcomeSocket = new ServerSocket(port);

			boolean exit = false;
			while(!exit) {

            Socket connectionSocket = welcomeSocket.accept();
            DataInputStream input =
               new DataInputStream(connectionSocket.getInputStream());
            DataOutputStream output = new DataOutputStream(connectionSocket.getOutputStream());
			if(input.available() != 0) {
			    int dir = input.readInt();
			    System.out.println("Received: " + dir);
			    
			    //Create what instructions mean and output correct information
			    
			    output.writeBytes("Received instruction from client");
				output.flush();
			}
         }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Server stopped running");
      }
   
   
}