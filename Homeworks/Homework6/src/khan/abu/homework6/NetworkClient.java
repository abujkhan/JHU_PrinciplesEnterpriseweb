/**
 * NetworkClient.java
 * 
 * Created on Oct 14, 2007, 11:27:41 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package khan.abu.homework6;
import java.net.*;
import java.io.*;

/**
 *
 * @author evansrb1
 * Modified by Abu Khan
 * October 12, 2014
 */
public class NetworkClient {

    private final String host;
    private final int port;
    private String returnMessage;
    
    public NetworkClient(String host, int port) {
        this.host = host;
        this.port = port;
    }
    public String getMessage(){
        return returnMessage;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public void connect(String message) {
        try {
            Socket client = new Socket(host, port);
            handleConnection(client, message);
            close(client);
        } catch (UnknownHostException uhe) {
            System.out.println("Unknown host: " + host);
            uhe.printStackTrace();
        } catch (IOException ioe) {
            System.out.println("IOException on: " + host);
            ioe.printStackTrace();
        }
    }
    
    public void close(Socket client) throws IOException {
        if (client != null) client.close();
    }
    
    protected void  handleConnection(Socket client, String message) throws IOException {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new PrintWriter(client.getOutputStream(), true);
            out.println(message);
            returnMessage =  in.readLine();
        } finally {
            if (out != null) out.close();
            if (in != null) in.close();
        }
    }            
            
}