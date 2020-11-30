/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.dao;

import client.Main;
import client.Register;
import connection.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author caoquangtrong
 */
public class CheckLogout {
    public static int checkLogout(String username) {
        Connection con = null;
        Statement st = null;
        int result = 0;
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sqlUpdateStatus = "UPDATE `user` SET `status`=0 WHERE username='"+username+"'";

            result = st.executeUpdate(sqlUpdateStatus);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
