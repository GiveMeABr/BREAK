package loginpackage;

import controller.DbConnect;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
 
/**
 * Servlet implementation class MySQLConnect
 */

    public class LoginServlet extends HttpServlet {
         
    //private static final long serialVersionUID = 1L;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        try(PrintWriter out = response.getWriter()){
           
        String user = request.getParameter("text");
        String pass = request.getParameter("password");
        
        Cookie ck = new Cookie("auth", user);
        ck.setMaxAge(600);
        
        DbConnect dbCon = new DbConnect();
        Connection connect = dbCon.getCon();
        
            PreparedStatement pst = connect.prepareStatement
        ("SELECT Username, UserSecretCode FROM break.Users where Username=? and UserSecretCode=?");
            
            pst.setString(1, user);
            pst.setString(2, pass);
            
            ResultSet rs = pst.executeQuery();
            
            if (rs.next()) {
                response.addCookie(ck);
                response.sendRedirect("index.html");
            } else {
                RequestDispatcher rd = request.getRequestDispatcher("login.html");
                rd.include(request, response);
            }
            } catch (SQLException ex) {
                
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}