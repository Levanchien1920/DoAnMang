/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author iamChien.iter
 */
public class CheckAccountSetting {

    public static boolean checkAccountSetting(int id, String username, String fullname, String password, String description) {
        Connection con = null;
        Statement st = null;
        int result = 0;
        boolean t = false;
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql1 = "UPDATE user SET username='" + username + "',fullname='" + fullname + "',description='"
                    + description + "',password='" + password + "' WHERE id=" + id;
            result = st.executeUpdate(sql1);
            t = true;
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }

    public static boolean checkPassword(int id, String password) {
        Connection con = null;
        Statement st = null;
        int result = 0;
        boolean t = false;
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql1 = "UPDATE user SET password='" + password + "' WHERE id=" + id;
            result = st.executeUpdate(sql1);
            t = true;
            return t;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return t;
    }

}
