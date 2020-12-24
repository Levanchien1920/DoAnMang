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
public class Conversation implements Serializable{
    private int id_con;
    private int id_from;
    private int id_to;

    public Conversation(int id_con, int id_from, int id_to) {
        this.id_con = id_con;
        this.id_from = id_from;
        this.id_to = id_to;
    }

    public int getId_con() {
        return id_con;
    }

    public void setId_con(int id_con) {
        this.id_con = id_con;
    }

    public int getId_from() {
        return id_from;
    }

    public void setId_from(int id_from) {
        this.id_from = id_from;
    }

    public int getId_to() {
        return id_to;
    }

    public void setId_to(int id_to) {
        this.id_to = id_to;
    }
    
    
}
