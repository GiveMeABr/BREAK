package fileupload;

import controller.DbController;
import java.io.*;
import javax.ejb.EJB;
import javax.servlet.http.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import model.Article;
import model.Users;
 

@WebServlet(name = "articleUpload", urlPatterns = {"/articleUpload"})
public class ArticleUpload extends HttpServlet {
    
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
         
    //private static final long serialVersionUID = 1L;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
                        
            String title = request.getParameter("title");
            String article = request.getParameter("article");
            
            Users u = dbc.getUser("anon");
            
            Article a = new Article();
            a.setTitle(title);
            a.setArticle(article); 
            a.setNsfw(false);
            a.setHasMedia(false);
            a.setSender(u);
            
            dbc.insertArticle(a);
            response.setHeader("Refresh", "0; URL=" + request.getContextPath());

        }
    }
}