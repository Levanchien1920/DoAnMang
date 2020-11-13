package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    
    
    // create a function to connect with mysql database
    
    public static Connection getConnection(){
     
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/network?serverTimezone=UTC", "root", "");
            System.out.println("Connected");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        return con;
    }
    
}    
