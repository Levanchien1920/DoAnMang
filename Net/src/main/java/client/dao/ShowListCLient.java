/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.dao;

import client.Register;
import connection.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.User;

/**
 *
 * @author caoquangtrong
 */
public class ShowListCLient {
    
    public static List<User> getAll(String username){
        List<User> result = new ArrayList<>();
        
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        String fullname = null;
        int status = 0;
        String uname = null;
        
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql = "Select username,fullname,status from user";
            rs = st.executeQuery(sql);
                
            while(rs.next()) {
                fullname = rs.getString("fullname");
                status = rs.getInt("status");
                uname = rs.getString("username");
                if(!uname.equals(username)){
                    User user = new User(fullname, status);
                    result.add(user);
                }
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return result;
    }
}
