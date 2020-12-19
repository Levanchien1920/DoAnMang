/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author iamChien.iter
 */
public class Message implements Serializable {

    private int id_msg;
    private String body_msg;
    private int id_user_from;
    private Date date_send;
    private int id_con;

    public Message() {
    }

    
    public Message(int id_msg, String body_msg, int id_user_from, Date date_send, int id_con) {
        this.id_msg = id_msg;
        this.body_msg = body_msg;
        this.id_user_from = id_user_from;
        this.date_send = date_send;
        this.id_con = id_con;
    }
    
    

    public int getId_msg() {
        return id_msg;
    }

    public void setId_msg(int id_msg) {
        this.id_msg = id_msg;
    }

    public String getBody_msg() {
        return body_msg;
    }

    public void setBody_msg(String body_msg) {
        this.body_msg = body_msg;
    }

    public int getId_user_from() {
        return id_user_from;
    }

    public void setId_user_from(int id_user_from) {
        this.id_user_from = id_user_from;
    }

    public Date getDate_send() {
        return date_send;
    }

    public void setDate_send(Date date_send) {
        this.date_send = date_send;
    }

    public int getId_con() {
        return id_con;
    }

    public void setId_con(int id_con) {
        this.id_con = id_con;
    }
    
    

    

}
