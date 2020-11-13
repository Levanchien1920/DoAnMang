/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iamChien.iter
 */
public class ConnectDB {

    public static void main(String[] args) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int id= 1;
        String name= "A";
        String password="123";
        int status =1;
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql1 = "INSERT INTO user(id,username,password,status) VALUES('" + id + "','" + name + "','" + password
                    + "','" + status + "')";
            int result = st.executeUpdate(sql1);

            if (result == 1) {

                System.out.println("Inserted");;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
