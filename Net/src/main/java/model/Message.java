/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author iamChien.iter
 */
public class Message implements Serializable{

    private int id_msg;
    private String body_msg;
    private String user_from;
    private String date_send;
    private int id_con;

    public Message(int id_msg, String body_msg, String user_from, String date_send, int id_con) {
        this.id_msg = id_msg;
        this.body_msg = body_msg;
        this.user_from = user_from;
        this.date_send = date_send;
        this.id_con = id_con;
    }

    public Message() {
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

    public String getUser_from() {
        return user_from;
    }

    public void setUser_from(String user_from) {
        this.user_from = user_from;
    }

    public String getDate_send() {
        return date_send;
    }

    public void setDate_send(String date_send) {
        this.date_send = date_send;
    }

    public int getId_con() {
        return id_con;
    }

    public void setId_con(int id_con) {
        this.id_con = id_con;
    }

}
