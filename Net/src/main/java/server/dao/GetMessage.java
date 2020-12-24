package server.dao;

import connection.MyConnection;
import java.sql.Connection;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Message;


public class GetMessage {
    public static List<Message> getMessageByIdCon(int idConversation) {
        List<Message> messages = new ArrayList<>();
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

        int id_message;
        String body;
        int id_user_from;
        int id_con;
        Timestamp date_send;
        
        try {
            con = MyConnection.getConnection();
            st = con.createStatement();
            String sql = "Select * from message where id_con="+idConversation;
            rs = st.executeQuery(sql);

            while (rs.next()) {
                id_message = rs.getInt("id_msg");
                body = rs.getString("body_msg");
                id_user_from = rs.getInt("id_user_from");
                id_con = rs.getInt("id_con");
                date_send = rs.getTimestamp("date_send");
                Message me = new Message(id_message, body, id_user_from, date_send, id_con);
                messages.add(me);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return messages;
    }
//    public static List<Message> getAll(int id) {
//        List<User> users = new ArrayList<>();
//        Connection con = null;
//        Statement st = null;
//        ResultSet rs = null;
//
//        String fullname = null;
//        int status = 0;
//        String uname = null;
//        int id = 0;
//        String des = null;
//        String password = null;
//
//        try {
//            con = MyConnection.getConnection();
//            st = con.createStatement();
//            String sql = "Select id,username,fullname,status,description from user";
//            rs = st.executeQuery(sql);
//
//            while (rs.next()) {
//                fullname = rs.getString("fullname");
//                status = rs.getInt("status");
//                uname = rs.getString("username");
//                id = rs.getInt("id");
//                des = rs.getString("description");
//                if (!uname.equals(username)) {
//                    User user = new User(id, fullname, des, status);
//                    users.add(user);
//                }
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return users;
//    }
}
