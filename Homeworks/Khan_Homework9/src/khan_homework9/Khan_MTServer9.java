/*
Abu Khan
Server Socket program
Date: 10/30/2014

 */

package khan_homework9;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author abu
 */
public class Khan_MTServer9 {
      public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        
        try {
            
            serverSocket = new ServerSocket(20007);//abu khan port
            //System.out.println("Listening");
            
        } catch (IOException e) {
            System.err.println("Could not listen on port: 20007.");
            System.exit(1);
        }

        Socket clientSocket = null;
        while (true) {
            clientSocket = serverSocket.accept();
            ClientThread thread = new ClientThread(clientSocket);
            thread.start();
        }
    }
    
}
