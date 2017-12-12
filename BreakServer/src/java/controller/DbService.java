/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Users;
import model.Article;
import model.Tags;

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

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("articles")
    public Article postArticle(
            @FormParam("title") String title,
            @FormParam("article") String article) {
        
        Users us = dbc.getUser("anon");
        Article a = new Article();
        
        a.setSender(us);
        a.setTitle(title);
        a.setArticle(article);
        a.setNsfw(false);
        a.setHasMedia(false);
       
        return dbc.insertArticle(a);
    }

}
