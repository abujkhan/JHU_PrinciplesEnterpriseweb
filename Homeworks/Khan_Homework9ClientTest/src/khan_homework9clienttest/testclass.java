/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package khan_homework9clienttest;

/**
 *
 * @author abutest
 */

import java.io.DataInputStream;
import java.io.PrintStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class testclass {
  public static void main(String[] args) {

    Socket clientSocket = null;
    DataInputStream is = null;
    PrintStream os = null;
    DataInputStream inputLine = null;

    /*
     * Open a socket on port 2222. Open the input and the output streams.
     */
    try {
      clientSocket = new Socket("web6.jhuep.com", 20007);
      os = new PrintStream(clientSocket.getOutputStream());
      is = new DataInputStream(clientSocket.getInputStream());
      inputLine = new DataInputStream(new BufferedInputStream(System.in));
      NetworkClient nc = new NetworkClient("web6.jhuep.com", 20007);
               // String info = packageComboBox.getSelectedIndex() + ":"+ year +":"+ month + ":"+day +":"+ numberofdaysComboBox.getSelectedItem().toString();
                String info = "2014:8:1:2014:8:5";
                nc.connect(info);
                
                String rowResult = nc.getMessage();
                        
                System.out.println(rowResult);
    } catch (UnknownHostException e) {
      System.err.println("Don't know about host");
    } catch (IOException e) {
      System.err.println("Couldn't get I/O for the connection to host");
    }

    /*
     * If everything has been initialized then we want to write some data to the
     * socket we have opened a connection to on port 2222.
     */
    if (clientSocket != null && os != null && is != null) {
      try {

        /*
         * Keep on reading from/to the socket till we receive the "Ok" from the
         * server, once we received that then we break.
         */
        System.out.println("The client started. Type any text. To quit it type 'Ok'.");
        String responseLine;
        os.println(inputLine.readLine());
        while ((responseLine = is.readLine()) != null) {
          System.out.println(responseLine);
          if (responseLine.indexOf("Ok") != -1) {
            break;
          }
          os.println(inputLine.readLine());
        }

        /*
         * Close the output stream, close the input stream, close the socket.
         */
        os.close();
        is.close();
        clientSocket.close();
      } catch (UnknownHostException e) {
        System.err.println("Trying to connect to unknown host: " + e);
      } catch (IOException e) {
        System.err.println("IOException:  " + e);
      }
    }
  }
}