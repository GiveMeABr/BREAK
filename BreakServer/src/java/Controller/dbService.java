/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import model.Users;
import model.Article;

/**
 * REST Web Service
 *
 * @author Eero
 */
@Path("service")
public class dbService {

    @EJB
    private dbController dbc;

    /**
     * Creates a new instance of GenericResource
     */
    public dbService() {
    }

    Users u = new Users();

    /**
     * Retrieves representation of an instance of model.GenericResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getJson() {
        return dbc.getAll();
    }

    public List<Article> getJsonArticle() {
        return dbc.getAllArticle();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("users")
    public Response post(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("email") String email,
            @FormParam("ModStatus") boolean ModStatus) {

//____________________CHECK IF USERNAME IS TAKEN_____________________________________    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://10.114.34.142:3306/break", "break", "breakdance");
            java.sql.Statement stmt = con.createStatement();

            String SQL = "SELECT * FROM break.Users WHERE Username='" + username + "'";

            ResultSet rs = stmt.executeQuery(SQL);

            if (rs.next()) {
                System.out.println("Username taken!");

            } else {
                u.setUsername(username);
            }

        } catch (Exception e) {

            System.out.println("Error : " + e.getMessage());
        }
//___________________________________________________________________________________    

        u.setUserSecretCode(password);
        u.setEmail(email);
        u.setModStatus(ModStatus);
        return Response.ok(dbc.insert(u)).cookie(new NewCookie("moi olen", "keksi")).build();

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("articles")
    public Article postArticle(
            @FormParam("title") String title,
            @FormParam("article") String article,
            @FormParam("nsfw") boolean nsfw) {
        Article a = new Article();

        //DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        //Date date = new Date();
        a.setArticle(article);
        a.setTitle(title);
        //a.setUploadDate(date);
        a.setNsfw(nsfw);
        //a.setSender(???);
        return dbc.insertArticle(a);
    }
    
    public String srcAddr;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("upload")
    public Article postArticleUpload(
            @FormParam("title") String title,
            @FormParam("nsfw") boolean nsfw) {

        Article a = new Article();

        a.setArticle(srcAddr);
        a.setTitle(title);
        //a.setUploadDate(date);
        a.setNsfw(nsfw);
        //a.setSender(???);
        return dbc.insertArticle(a);
    }

}
