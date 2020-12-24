/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Message;
import model.Conversation;

/**
 *
 * @author caoquangtrong
 */
public class GetConversation {
    public static List<Conversation> getAllConversations(int id_user) {
        List<Conversation> conversations = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        int id_con;
        int id_from;
        int id_to;
        
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql = "Select * from conversation where id_from="+id_user+" or id_to="+id_user;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                id_con = rs.getInt("id_con");
                id_from = rs.getInt("id_from");
                id_to = rs.getInt("id_to");
                conversations.add(new Conversation(id_con, id_from, id_to));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conversations;
    }
    
    public static int checkIsConversationExist(Message me) {
        List<Conversation> conversations = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        
        int id_con = me.getId_con();
        int id_from = me.getId_user_from();
        int id_to = me.getId_user_to();
        
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql = "Select * from conversation where id_con="+id_con;
            rs = st.executeQuery(sql);

            if(rs.next()){
                //them message
                String insertMes = "INSERT INTO `message`(`body_msg`, `date_send`, `id_user_from`, `id_con`) VALUES ('"+me.getBody_msg()+"',CURRENT_TIMESTAMP(),"+id_from+","+id_con+")";
                st.executeUpdate(insertMes);
                return 1;
                
            }else{
                //them con
                String insertCon = "INSERT INTO `conversation`(`id_con`, `id_from`, `id_to`) VALUES ("+id_con+","+id_from+","+id_to+")";
                st.executeUpdate(insertCon);
                //them message
                String insertMes = "INSERT INTO `message`(`body_msg`, `date_send`, `id_user_from`, `id_con`) VALUES ('"+me.getBody_msg()+"',CURRENT_TIMESTAMP(),"+id_from+","+id_con+")";
                st.executeUpdate(insertMes);
                
                return 1;
            }

        } catch (SQLException e) {
        }

        return 0;
    }
}
