/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
/**
 *
 * @author Eero
 */
@Stateless
public class DbController {
    
    @PersistenceContext
    private EntityManager em;
    
    public DbController (){
        
    }
    
    public List<Users> getAll(){
       List<Users> lst = em.createNamedQuery("Users.findAll").getResultList(); 
       return lst;
    }
    
    public List<Users> getUsername(){
       List<Users> lst = em.createNamedQuery("Users.findByUsername").getResultList(); 
       return lst;
    }
    
    public List<Article> getAllArticle(){
       List<Article> lst = em.createNamedQuery("Article.findAll").getResultList(); 
       return lst;
    }
    
    public List<Article> getMedia(){
            return em.createQuery("SELECT a.articleID, a.article, a.title FROM Article a").getResultList();
    }
    
    public List<Votes> getVotes(){
            return em.createQuery("SELECT v.votesPK.article, v.voteType FROM Votes v").getResultList();
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
