/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileupload;

import controller.DbConnect;
import controller.DbController;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Users;

/**
 *
 * @author nyman
 */
@MultipartConfig(location = "/var/www/html/profilepics")
@WebServlet(name = "UserRegister", urlPatterns = {"/register"})
public class UserRegister extends HttpServlet {

    @EJB
    private DbController dbc;

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
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {

            request.getPart("fileup").write(request.getPart("fileup").getSubmittedFileName());
            out.print("{\"src\" : \"http://10.114.34.142/profilepics/" + request.getPart("fileup").getSubmittedFileName() + "\"}");

            String imgSrc = "http://10.114.34.142/profilepics/" + request.getPart("fileup").getSubmittedFileName();
            String userName = request.getParameter("username");
            String email = request.getParameter("email");
            String passwd = request.getParameter("password");

            out.print(" " + userName + " " + passwd + " " + email);

            Users u = new Users();
            Cookie ck = new Cookie("auth", userName);
            ck.setMaxAge(600);

            DbConnect dbCon = new DbConnect();
            Connection connect = dbCon.getCon();

            java.sql.Statement stmt = connect.createStatement();
            String SQL = "SELECT * FROM break.Users WHERE Username='" + userName + "'";
            ResultSet rs = stmt.executeQuery(SQL);

            if (rs.next()) {
                response.sendRedirect("register.html");

            } else {

                u.setUsername(userName);
                u.setEmail(email);
                u.setUserSecretCode(passwd);
                u.setProfilePic(imgSrc);
                u.setModStatus(false);
                dbc.insert(u);

                response.addCookie(ck);
                response.sendRedirect("index.html");
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserRegister.class.getName()).log(Level.SEVERE, null, ex);
        }

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
