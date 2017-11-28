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
import model.User;

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
    
    public List<User> getAll(){
       List<User> lst = em.createNamedQuery("User.findAll").getResultList(); 
       return lst;
    }
    
    public User insert(User u) {
        em.persist(u);
        return u;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
