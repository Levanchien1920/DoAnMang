/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.User;

/**
 *
 * @author caoquangtrong
 */
public class GetUser {

    public static User getUserByUsername(String username) {
        User user = new User();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String fullname = null;
        int status = 0;
        String uname = null;
        int id = 0;
        String des = null;
        String password = null;

        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql = "Select * from user where username ='" + username + "'";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                fullname = rs.getString("fullname");
                status = rs.getInt("status");
                uname = rs.getString("username");
                id = rs.getInt("id");
                des = rs.getString("description");

                
                    user = new User(id, uname, fullname, password, des, status);
                

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static List<User> getAll(String username) {
        List<User> users = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        String fullname = null;
        int status = 0;
        String uname = null;
        int id = 0;
        String des = null;
        String password = null;

        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql = "Select id,fullname,status,description from user";
            rs = st.executeQuery(sql);

            while (rs.next()) {
                fullname = rs.getString("fullname");
                status = rs.getInt("status");
                uname = rs.getString("username");
                id = rs.getInt("id");
                des = rs.getString("description");

                User user = new User(id, fullname, des, status);
                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
