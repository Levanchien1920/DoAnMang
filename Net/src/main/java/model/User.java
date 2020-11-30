/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author iamChien.iter
 */
public class User {

    private int id;
    private String username;
    private String fullname;
    private String password;
    private String description;
    private int status;

    public User(int id, String username, String fullname, String password, String description, int status) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
        this.password = password;
        this.description = description;
        this.status = status;
    }

    public User() {
    }

    public User(String fullname, int status) {
        this.fullname = fullname;
        this.status = status;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getFullname() {
        return fullname;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }

    public int getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    
    

}
