/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iamChien.iter
 */
public class CheckRegister {
    
    public static boolean checkRegister(String username, String password, String fullname) {
        Connection con = null;
        Statement st = null;
        int status = 0;
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql1 = "INSERT INTO user(username,password,fullname, status) VALUES('" + username + "','" + password + "','" + fullname
                    + "','" + status + "')";
            int result = st.executeUpdate(sql1);

            if (result == 1) {
                System.out.println("Inserted");
                return true;
            }
            else{
                System.out.println("Not inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
