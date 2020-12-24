/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author caoquangtrong
 */
public class Process implements Serializable {

    private User user;
    private Message message;
    private String control;
    private Boolean reply;
    private List<User> listUsers;
    private List<ListMessage> listMessages;


    public Process(List<User> listUsers,String control) {
        this.control = control;
        this.listUsers = listUsers;
    }
    public List<User> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<User> listUsers) {
        this.listUsers = listUsers;
    }
    
    public Process(String control, List<ListMessage> listMessages) {
        this.control = control;
        this.listMessages = listMessages;
    }

    public Process(String control,User user) {
        this.user = user;
        this.control = control;
    }

    
    
    public List<ListMessage> getListMessages() {
        return listMessages;
    }

    public void setListMessages(List<ListMessage> listMessages) {
        this.listMessages = listMessages;
    }
    
    

    public Process(User user, Message message, String control, Boolean reply, List<User> listUsers) {
        this.user = user;
        this.message = message;
        this.control = control;
        this.reply = reply;
        this.listUsers = listUsers;
    }
    

    public Process(User user, Message message, String control, Boolean reply) {
        this.user = user;
        this.message = message;
        this.control = control;
        this.reply = reply;
    }

    public Boolean getReply() {
        return reply;
    }

    public void setReply(Boolean reply) {
        this.reply = reply;
    }

    public Process(String control, User user, Message message) {
        this.user = user;
        this.message = message;
        this.control = control;
        this.reply = null;
    }

    public Process() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    @Override
    public String toString() {
        return "Process{" + "user=" + user + ", message=" + message + ", control=" + control + '}';
    }

}
