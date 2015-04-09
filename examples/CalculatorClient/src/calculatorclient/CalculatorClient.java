/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package calculatorclient;

/**
 *
 * @author abu
 */
public class CalculatorClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Adding 3 and 4 gives " + add(3,4));
    }

    private static int add(int i, int j) {
        calculatorclient.CalculatorWS_Service service = new calculatorclient.CalculatorWS_Service();
        calculatorclient.CalculatorWS port = service.getCalculatorWSPort();
        return port.add(i, j);
    }
    
}
