/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iamChien.iter
 */
public class CheckRegister {

    public static void main(String[] args) {
    }
      public static void checkRegister(String username, String password) {
        Connection con = null;
        Statement st = null;
        int id =2;
        int status = 0;
        try {
             con = MyConnection.getConnection();
            st = con.createStatement();
            String sql1 = "INSERT INTO user(username,password,status) VALUES('" + username + "','" + password
                    + "','" + status + "')";
            int result = st.executeUpdate(sql1);

            if (result == 1) {

                System.out.println("Inserted");;

            }
            else{
                System.out.println("Not inserted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
