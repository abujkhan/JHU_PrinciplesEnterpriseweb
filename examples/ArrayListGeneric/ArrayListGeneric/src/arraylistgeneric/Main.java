/*
 * Main.java
 *
 * Created on September 20, 2007, 9:39 AM
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package arraylistgeneric;

import java.util.*;
/**
 *
 * @author evansrb1
 */
public class Main {
    
    /** Creates a new instance of Main */
    public Main() {
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int numberOfItems = 5;
        
        ArrayList<String> list = new ArrayList<String>();
        for (int i=0; i < numberOfItems; i++ ) {
            list.add(new String("List item number " + i));
        }
        
        for (int i=0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
    }
    
}
