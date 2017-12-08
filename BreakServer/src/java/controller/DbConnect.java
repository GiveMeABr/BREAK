package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Eero
 */
public class DbConnect {
    
    public Connection con;
    
    public Connection getCon(){
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            con =  DriverManager.getConnection("jdbc:mysql://10.114.34.142:3306/break", "break", "breakdance");
            System.out.println("Connected to database");
            
        } catch (ClassNotFoundException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } catch (SQLException e) {
            
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        }
        return con;
        }
}
    

