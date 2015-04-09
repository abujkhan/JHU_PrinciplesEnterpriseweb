/*
 Abu Khan
Homework 9
ClientThread.java
date: 10/30/2014
 */

package khan_homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author evansrb1
 */
public class ClientThread extends Thread {

    private final Socket socket;
    public ClientThread(Socket clientSocket) {
        this.socket = clientSocket;
    }
    private synchronized String processOutput(String inString)
    {
        String errMessage = "";
        String retMessage = "";
      
        if (inString.contains(":"))
        {
                try 
                {
                    String[] inArray = inString.split(":");
                    if (inArray.length ==7)
                    {
                        if (inArray[0].length()!=4)
                        {
                            errMessage +="Year needs to be of four digits";
                        }
                        else
                        {
                            Integer intYear = Integer.parseInt(inArray[0]);
                            Integer intMonth = Integer.parseInt(inArray[1]);
                            Integer intDay = Integer.parseInt(inArray[2]);
                            Integer endYear = Integer.parseInt(inArray[3]);
                            Integer endMonth = Integer.parseInt(inArray[4]);
                            Integer endDay = Integer.parseInt(inArray[5]);
                            double baseRate = Double.parseDouble(inArray[6]);

                            BookingDay startDate = new BookingDay(intYear,intMonth,intDay );
                            if (startDate.isValidDate())
                             {
                                Rates rates = new Rates();
                                rates.setBaseRate(baseRate);
                                //set begin date
                                rates.setBeginDate(startDate);
                                BookingDay endDate = new BookingDay(endYear, endMonth, endDay);
                                 if (endDate.isValidDate())
                                        {
                                             rates.setEndDate(endDate);
                                              if (rates.isValidDates())
                                              {
                                                  retMessage =  rates.getCost() + " : Quoted Rate";
                                              }
                                              else
                                              {
                                                   errMessage +=  " Sorry but " +rates.getDetails(); 
                                              }
                                         }
                                         else
                                          {
                                                errMessage += "End Date, " + endDate.toString() + " is either out of calculation date limit or invalid date"; 
                                          }
                             }
                             else
                             {
                                   errMessage += "Start Date, " + startDate.toString() + " is either out of calculation date limit or invalid date" ;
                             }
                        }
                       }
                        else
                        {
                            errMessage += "Wrong number of arguments";
                        }

                 }
                  catch (NumberFormatException nfe)
                  {
                    errMessage += nfe.getLocalizedMessage();
                  }
        }
        else
        {
             errMessage +="Input does not contain : ";
        }
      
        if (errMessage.length()==0)
          return retMessage;
        else
          return " -0.01 : " + errMessage   ;
    }
    public void run () 
    {
        BufferedReader in = null;
        PrintWriter out = null;
        try 
        {
            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String outputLine = null;
            while (!socket.isClosed()) 
            {
                outputLine = in.readLine();
                if (outputLine !=null)
                {
                    String outString = processOutput(outputLine);
                    out.println(outString);
                }
                else
                 break;
            }
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
        finally 
        {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
