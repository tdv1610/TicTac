/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.sql.Timestamp;

public class TinNhanDTO {
    private String sender;
    private String receiver;
    private String text;
    private Timestamp timestamp;

    // Constructor
    public TinNhanDTO(String sender, String receiver, String text, Timestamp timestamp) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.timestamp = timestamp;
    }
    
    public TinNhanDTO(){
        
    }

    // Getters and Setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
