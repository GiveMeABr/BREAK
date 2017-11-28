/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import model.User;

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

    /**
     * Retrieves representation of an instance of model.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getJson() {
       return dbc.getAll();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User post(
            @FormParam("username") String username,
            @FormParam("password") String password,
            @FormParam("email") String email,
            @FormParam("ModStatus") boolean ModStatus){
        User u = new User();
        u.setUsername(username);
        u.setUserSecretCode(password);
        u.setEmail(email);
        u.setModStatus(ModStatus);
        return dbc.insert(u);
    }
    
    

}
