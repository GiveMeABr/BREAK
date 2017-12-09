/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
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
import model.Tags;
import model.Votes;

/**
 * REST Web Service
 *
 * @author Eero
 */
@Path("service")
public class DbService {

    @EJB
    private DbController dbc;

    /**
     * Creates a new instance of GenericResource
     */
    public DbService() {
    }

    Users u = new Users();

    /**
     * Retrieves representation of an instance of model.GenericResource
     *
     * @return an instance of java.lang.String
     */

    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getJson() {
        return dbc.getAll();
    }
    

    @Produces(MediaType.APPLICATION_JSON)
    public List<Article> getJsonArticle() {
        return dbc.getMedia();
    }

    @GET
    @Path("getMedia")
    public String json() {
        return dbc.getMediaJson();

        
        
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getVotes")
    public List<Votes> getJsonVotes() {
        return dbc.getVotes();
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
            @FormParam("article") String article) {

        Article a = new Article();

        a.setTitle(title);
        a.setArticle(article);
        a.setNsfw(false);
        a.setHasMedia(false);
        //a.setSender(???);
        return dbc.insertArticle(a);

    }

    public Tags postTags(
            @FormParam("tags") String tags) {

        Tags t = new Tags();
        t.setTag(tags);
        return dbc.insertTags(t);
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
