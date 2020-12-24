/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Conversation;
/**
 *
 * @author caoquangtrong
 */
public class ListMessage implements Serializable{
    private Conversation conversation;
    private List<Message> listMessage = new ArrayList<>();

    public ListMessage(Conversation conversation, List<Message> listMessage) {
        this.conversation = conversation;
        this.listMessage = listMessage;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }

    public List<Message> getListMessage() {
        return listMessage;
    }

    public void setListMessage(List<Message> listMessage) {
        this.listMessage = listMessage;
    }
    
    public void addToListMessage(Message me){
        this.listMessage.add(me);
    }
    
}
