/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.net.Socket;

/**
 *
 * @author caoquangtrong
 */
public class UserSocket {
    Socket socket;
    User user;

    public UserSocket(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    public UserSocket() {
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public String toString() {
        return "UserSocket{" + "socket=" + socket + ", user=" + user.getUsername() + '}';
    }

    
    
    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    
    
}
