/*
By Abu Khan
module: Khan_Controller10
Date: Nov 6, 2014
 */

package Homework10;

import static Homework10.DateCheck.isDateFormatValid;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abu
 */
@WebServlet(name = "Khan_Controller10", urlPatterns = {"/Khan_Controller10"})
public class Khan_Controller10 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String beginDate = null;
        String numberOfPeople=null;
        String selectPackage=null;
        String selectDuration=null;
        String errMessage = "";
        String retMessage = "";
        double baseRate= 0.0; 
        ServletContext servletContext = getServletContext();
        try {
            beginDate = request.getParameter("textbegindate");
           
            numberOfPeople = request.getParameter("textnumberofpeople");
            selectPackage = request.getParameter("selectpackage");
            selectDuration = request.getParameter("selectduration");
            if (selectPackage==null)
            {
                errMessage += "package not selected";
            }
            else if (selectDuration==null)
            {
                errMessage += "Duration not selected";
            }
            else if (beginDate==null)
                errMessage += "Begin Date must be entered";
            else if (isDateFormatValid(beginDate)==false)
                errMessage += "Begin Date needs to be mm/dd/yyyy format";
            else if (numberOfPeople==null)
                errMessage +=" Number of people must be entered";
            else
            {
             String[] arrdate = beginDate.split("/");
             Integer intYear = Integer.parseInt(arrdate[2]);
             Integer intMonth = Integer.parseInt(arrdate[0]);
             Integer intDay = Integer.parseInt(arrdate[1]);
             if ("1".equals(selectPackage))
                 baseRate = 35.00;
             else if ("2".equals(selectPackage))
                 baseRate = 40.00;
             else if ("3".equals(selectPackage))
                 baseRate = 45.00;
             BookingDay startDate = new BookingDay(intYear,intMonth,intDay );
             if (startDate.isValidDate())
             {
                Rates rates = new Rates();
                rates.setBaseRate(baseRate);
                //set begin date
                rates.setBeginDate(startDate);
                Integer duration = Integer.parseInt(selectDuration);
                Calendar gc =  new GregorianCalendar(intYear,intMonth-1,intDay);
                gc.add(Calendar.DATE,duration-1);
                int endYear = gc.get(Calendar.YEAR);
                int endMonth = gc.get(Calendar.MONTH);
                int endDay = gc.get(Calendar.DAY_OF_MONTH);
                BookingDay endDate = new BookingDay(endYear, endMonth+1, endDay);
                     
                 if (endDate.isValidDate())
                        {
                             rates.setEndDate(endDate);
                              if (rates.isValidDates())
                              {
                                  retMessage = "Total Cost: $"+ rates.getCost() + "   (Weekdays:"+ rates.getNormalDays() + "@ $" + rates.getBaseRate() + "  Weekends:" + rates.getPremiumDays()+"@ $" + rates.getPremiumRate()+")";
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
            if (errMessage.length()==0)
            {
              request.setAttribute("message", retMessage);
              RequestDispatcher dispatcher = servletContext.getRequestDispatcher("/result.jsp");
              dispatcher.forward(request, response);
              
            }
            else
            {
                request.setAttribute("message", errMessage);
                RequestDispatcher dispathcer = servletContext.getRequestDispatcher("/error.jsp");
                dispathcer.forward(request, response);

            }
        } catch (NumberFormatException nfe){
            
              request.setAttribute("message", nfe.getLocalizedMessage());
              RequestDispatcher dispathcer = servletContext.getRequestDispatcher("/error.jsp");
              dispathcer.forward(request, response);

        }
        
       

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
