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
import javax.swing.JOptionPane;

/**
 *
 * @author iamChien.iter
 */
public class CheckLogin {

    public static void main(String[] args) {

    }

    public static void checkLogin(String username, String password) {
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        int status = 1;
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql = "Select username,password from user WHERE password='" + password + "' and username='" + username + "'";
            rs = st.executeQuery(sql);

            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Password and Username is correct");
                MainFrameAllClient a = new MainFrameAllClient();
                a.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Password and Username is incorrect");
                Register r = new Register();
                r.setVisible(true);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}