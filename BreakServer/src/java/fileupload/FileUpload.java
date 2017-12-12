/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileupload;

import controller.DbController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Article;
import model.Tags;
import model.Users;

/**
 *
 * @author nyman
 */
@MultipartConfig(location = "/var/www/html/articles")
@WebServlet(name = "fileUpload", urlPatterns = {"/upload"})
public class FileUpload extends HttpServlet {

    @EJB
    private DbController dbc;
    private EntityManager em;

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
    protected void doPost(HttpServletRequest request, HttpServletResponse response
    )
            throws ServletException, IOException {
        response.setContentType("application/json");
        try (PrintWriter out = response.getWriter()) {
            request.getPart("fileup").write(request.getPart("fileup").getSubmittedFileName());
            out.print("{\"src\" : \"http://10.114.34.142/articles/" + request.getPart("fileup").getSubmittedFileName() + "\"}");

            String imgSrc = "http://10.114.34.142/articles/" + request.getPart("fileup").getSubmittedFileName();
            boolean nsfw = request.getParameter("nsfw") != null;


            Cookie[] cookies = request.getCookies();
            String username = "";

                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("auth")) {
                        username = cookie.getValue();
                    }
                }

            
            Users u = dbc.getUser(username);
            
            Article a = new Article();
            a.setArticle(imgSrc);
            a.setTitle(request.getParameter("title"));
            a.setNsfw(false);
            a.setHasMedia(true);
            a.setSender(u);
            
            dbc.insertArticle(a);
            response.setHeader("Refresh", "0; URL=" + request.getContextPath());

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
