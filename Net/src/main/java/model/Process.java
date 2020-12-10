/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author caoquangtrong
 */
public class Process implements Serializable {
    private User user;
    private Message message;
    private String control;

    public Process(String control, User user, Message message) {
        this.user = user;
        this.message = message;
        this.control = control;
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