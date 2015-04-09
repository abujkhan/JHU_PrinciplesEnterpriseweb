/*
 * Abu Khan
 * Homework 7
 * Date 10/17/2014
 */

package homework7;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abu
 */
@WebServlet(name = "Khan_Servlet7", urlPatterns = {"/Khan_Servlet7"})
public class Khan_Servlet7 extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        String year = null;
        String month = null;
        String day = null;
        String selectPackage=null;
        String selectDuration=null;
        String errMessage = "";
        String retMessage = "";
        double baseRate= 0.0; 
        try {
            /* TODO output your page here. You may use following sample code. */
            year = request.getParameter("year");
            month = request.getParameter("month");
            day = request.getParameter("day");
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
            else if (year==null)
                errMessage += "year not entered";
            else if (year.length() != 4)
                errMessage +=" year needs to be four digit";
            else
            {
             Integer intYear = Integer.parseInt(year);
             Integer intMonth = Integer.parseInt(month);
             Integer intDay = Integer.parseInt(day);
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
                // System.out.println(gc.get(Calendar.DAY_OF_MONTH));
                gc.add(Calendar.DATE,duration-1);
                //System.out.println(gc.get(Calendar.DAY_OF_MONTH));
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
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BHC Total Cost Estimate </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Estimated result " + "</h2>");
            out.println("<p>" + retMessage + "</p>");
            out.println("</body>");
            out.println("</html>");
            }
            else
            {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BHC Total Cost Estimate </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Error: " + "</h2>");
            out.println("<p>" + errMessage + "</p>");
            out.println("</body>");
            out.println("</html>");
            }
        } catch (NumberFormatException nfe){
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BHC Total Cost Estimate </title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Error: " + "</h2>");
            out.println("<p>" + nfe.getLocalizedMessage() + " need integer value!"   + "</p>");
            out.println("</body>");
            out.println("</html>");
           
        }
        
        finally {
            out.close();
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
