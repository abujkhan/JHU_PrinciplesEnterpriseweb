/*
 * Abu Khan
  *Homework 11
  *Date 11/10/14
 */

package homework11;

import static homework11.DateCheck.isDateFormatValid;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author abu
 */
@WebServlet(name = "Khan_Servlet11", urlPatterns = {"/Khan_Servlet11"})
public class Khan_Servlet11 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    private static final String USERNAME = "johncolter";
    private static final String PASSWORD = "LetMeIn";
    private static final String HOST = "web6.jhuep.com";
    private static final String DB = "mysql";
    private static final int PORT = 3306;
    private static final String DB_NAME = "class";
    private static final String SQL_STMT = "Select CONCAT(' ', reservation.StartDay) AS Dates, CONCAT(' ', locations.location) AS 'Tour Location',CONCAT(' ', guides.First ,' ', guides.Last) AS  'Guide Name', CONCAT('',reservation.First) AS 'Reservation FirstName', " +
            "  CONCAT('',reservation.Last) AS 'Reservation LastName'" +
            "  from reservation, locations, guides" +
            "  where reservation.location = locations.idlocations" +
            "  and reservation.guide = guides.idguides ";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String beginDate = null;
        String errMessage = "";
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException cnfe) {
            System.out.println("Error loading driver " + cnfe.getMessage());
        }
        try {
            beginDate = request.getParameter("textbegindate");
            
             if (beginDate==null)
             {
                errMessage = "Begin Date must be entered";
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>BHC Query Error </title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Error: " + "</h2>");
                out.println("<p>" + errMessage + "</p>");
                out.println("</body>");
                out.println("</html>");
             }
            else if (isDateFormatValid(beginDate)==false)
            {
                errMessage = "Begin Date needs to be mm/dd/yyyy format";
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>BHC Query Error </title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Error: " + "</h2>");
                out.println("<p>" + errMessage + "</p>");
                out.println("</body>");
                out.println("</html>");
            }
             else
            {
             String[] arrdate = beginDate.split("/");
             Integer intYear = Integer.parseInt(arrdate[2]);
             Integer intMonth = Integer.parseInt(arrdate[0]);
             Integer intDay = Integer.parseInt(arrdate[1]);
             BookingDay startDate = new BookingDay(intYear,intMonth,intDay );
             if (startDate.isValidDate())
             {
                    String dbURL = "jdbc:" + DB + "://" + HOST + ":" + PORT + "/" + DB_NAME;
                    Connection connection = DriverManager.getConnection(dbURL, USERNAME, PASSWORD);
                    Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    String fullQuery = SQL_STMT + "  and reservation.StartDay >= STR_TO_DATE('" + beginDate + "', '%m/%d/%Y') order by reservation.StartDay;" ;
                    
                    ResultSet resultSet = statement.executeQuery(fullQuery);
                    /* TODO output your page here. You may use following sample code. */
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>Beartooth Hiking Company Tours</title>");            
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<h1> Tour Query Result </h1>");
                    out.println("<p>");
                    out.println("<TABLE BORDER=1>");
                    ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                    int columnCount = resultSetMetaData.getColumnCount();  
                    out.println("<TR>");
                    for(int i=1; i <= columnCount; i++)
                    {
                        out.print("<TH>" + resultSetMetaData.getColumnName(i));
                    }
                    out.println();
                    resultSet.last();
                    int numberOfRows = resultSet.getRow();
                    if (numberOfRows==0)
                    {
                         out.println("<TR>");
                         out.print("<TD colspan=\"5\"> No result found for the criteria");
                         out.println();
                         out.println("</TABLE>");
                         
                    }
                    else
                    {
                        resultSet.beforeFirst();
                        // Step through each row in the result set.
                        while(resultSet.next()) {
                            out.println("<TR>");
                            // Step across the row, retrieving the data in each
                            // column cell as a String.
                            for(int i=1; i <= columnCount; i++) {
                            out.print("<TD>" + resultSet.getString(i));
                            }
                            out.println();
                        }
                        out.println("</TABLE>");
                    }
                    connection.close();

                    out.println("</body>");
                    out.println("</html>");
                }
                else
                {
                       errMessage = "Start Date, " + startDate.toString() + " is a invalid date" ;
                       out.println("<!DOCTYPE html>");
                       out.println("<html>");
                       out.println("<head>");
                       out.println("<title>BHC Query Error </title>");            
                       out.println("</head>");
                       out.println("<body>");
                       out.println("<h2>Error: " + "</h2>");
                       out.println("<p>" + errMessage + "</p>");
                       out.println("</body>");
                       out.println("</html>");
                }
            }
        }
        catch (SQLException sqle) {
               // System.err.println("error: " + sqle.getMessage());
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>BHC Query Error </title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h2>Error: " + "</h2>");
                out.println("<p>" + sqle.getMessage() + "</p>");
                out.println("</body>");
                out.println("</html>");
        }
         catch (NumberFormatException nfe){
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>BHC Query Error  </title>");            
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
