/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Users;
import model.Article;
/**
 *
 * @author Eero
 */
@Stateless
public class dbController {
    
    @PersistenceContext
    private EntityManager em;
    
    public dbController (){
        
    }
    
    public List<Users> getAll(){
       List<Users> lst = em.createNamedQuery("User.findAll").getResultList(); 
       return lst;
    }
    
    public List<Article> getAllArticle(){
       List<Article> lst = em.createNamedQuery("Article.findAll").getResultList(); 
       return lst;
    }
    
    public Users insert(Users u) {
        em.persist(u);
        return u;
    }
    
    public Article insertArticle(Article a) {
        em.persist(a);
        return a;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
