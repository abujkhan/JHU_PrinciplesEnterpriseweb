/*
 * Home work 12
 * Abu Khan
 * 11/20/2014
 */

package com.abu;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author abu
 */
@WebService(serviceName = "Homework12_WS")
public class Homework12_WS {
   

    /**
     * Web service operation
     * @param beginYear
     * @param beginMonth
     * @param beginDay
     * @param endYear
     * @param endMonth
     * @param endDay
     * @param baseRate
     * @param numberInParty
     * @return 
     */
    @WebMethod(operationName = "estimate")
    public String estimate(@WebParam(name = "beginYear") String beginYear, @WebParam(name = "beginMonth") String beginMonth, @WebParam(name = "beginDay") String beginDay, @WebParam(name = "endYear") String endYear, @WebParam(name = "endMonth") String endMonth, @WebParam(name = "endDay") String endDay, @WebParam(name = "baseRate") String baseRate , @WebParam(name = "numberInParty") String numberInParty) {
        //TODO write your implementation code here:
        String errMessage = "";
        String retMessage = "";
         try 
           {
            Integer intYear = Integer.parseInt(beginYear);
            Integer intMonth = Integer.parseInt(beginMonth);
            Integer intDay = Integer.parseInt(beginDay);
            Integer intendYear = Integer.parseInt(endYear);
            Integer intendMonth = Integer.parseInt(endMonth);
            Integer intendDay = Integer.parseInt(endDay);
            double doublebaseRate = Double.parseDouble(baseRate);
            Integer intnumberInParty = Integer.parseInt(numberInParty);
            if (intnumberInParty < 1 || intnumberInParty > 10)
                errMessage += "Number in Party needs to be between 1 and 10";
            else
            {
             BookingDay startDate = new BookingDay(intYear,intMonth,intDay );
             if (startDate.isValidDate())
                {
                   Rates rates = new Rates();
                   rates.setBaseRate(doublebaseRate);
                   //set begin date
                   rates.setBeginDate(startDate);
                   BookingDay endDate = new BookingDay(intendYear, intendMonth, intendDay);
                    if (endDate.isValidDate())
                        {
                             rates.setEndDate(endDate);
                              if (rates.isValidDates())
                              {
                                  retMessage =  intnumberInParty*rates.getCost() + " : Quoted Rate";
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
          
        catch (NumberFormatException nfe)
        {
          errMessage += nfe.getLocalizedMessage();
        }
         if (errMessage.length()==0)
          return retMessage;
        else
          return " -0.01 : " + errMessage   ;
    }
    
}
