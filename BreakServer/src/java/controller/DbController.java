/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Users;
import model.Article;
import model.Tags;
import model.Votes;
import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;
import javax.ws.rs.CookieParam;

/**
 *
 * @author Eero
 */
@Stateless
public class DbController {

    @PersistenceContext
    private EntityManager em;

    public DbController() {

    }

    public List<Users> getAll() {
        List<Users> lst = em.createNamedQuery("Users.findAll").getResultList();
        return lst;
    }

    public List<Users> getUsername() {
        List<Users> lst = em.createNamedQuery("Users.findByUsername").getResultList();
        return lst;
    }

    public List<Article> getAllArticle() {
        List<Article> lst = em.createNamedQuery("Article.findAll").getResultList();
        return lst;
    }
    
    public List<Article> getPaskaEsimerkki(String title) {
        List<Article> lst = em.createNamedQuery("Article.findByTitle").setParameter("title", title).getResultList();
        return lst;
    }
    
    
    
    public int getUser(String username) {
        int usr = em.createNamedQuery("Users.findByUsername").setParameter("username", username).getResultList().indexOf(1);
        return usr;
    }
    
    public Users UserId(String username) {
        Users u = getUserId(username).get(1);
        return u;
    }
    
    
    public List<Users> getUserId(String username) {
        List<Users> lst = em.createNamedQuery("Users.findByUsername").setParameter("username", username).getResultList();
        return lst;
    }

    public List<Article> getMedia() {
        List<Article> lst = em.createNamedQuery("Article.findByMedia").getResultList();
        return lst;
    }

    public String getMediaJson() {
        String json = new Gson().toJson(getMedia());
        return json;
    }

    public Users insert(Users u) {
        em.persist(u);
        return u;
    }

    public Article insertArticle(Article a) {
        em.persist(a);
        return a;
    }

    public Tags insertTags(Tags t) {
        em.persist(t);
        return t;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
