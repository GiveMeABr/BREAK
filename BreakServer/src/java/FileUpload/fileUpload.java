/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileUpload;

import Controller.dbController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.FormParam;
import model.Article;

/**
 *
 * @author nyman
 */
@MultipartConfig(location = "/var/www/html/articles")
@WebServlet(name = "fileUpload", urlPatterns = {"/do"})
public class fileUpload extends HttpServlet {
    
    @EJB
    private dbController dbc;

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
            out.print("{\"src\" : \"//10.114.34.142/articles/" + request.getPart("fileup").getSubmittedFileName() +"\"}");
            String imgSrc = "//10.114.34.142/articles/" + request.getPart("fileup").getSubmittedFileName();
            
            Article a = new Article();
            
            a.setArticle(imgSrc);
            dbc.insertArticle(a);
        
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
