/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;
import java.util.Random;

/**
 *
 * @author Ngcebo
 */

public class Message {
    private String messageID;
    private int numMessagesSent; 
    private String recipientNumber;
    private String messageContent;
    private String messageHash;
    
    private static int totalMessagesSentCount = 0;

    public Message(int numMessagesSent, String recipientNumber, String messageContent) {
        this.numMessagesSent = numMessagesSent;
        this.recipientNumber = recipientNumber;
        this.messageContent = messageContent;
        this.messageID = generateRandomMessageID();
        this.messageHash = createMessageHash();
    }

    private String generateRandomMessageID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    public boolean checkMessageID() {
        return this.messageID != null && this.messageID.length() <= 10;
    }

    public String checkRecipientCell(String phoneNumber) {
        if (phoneNumber != null && phoneNumber.startsWith("+") && phoneNumber.length() <= 13) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String createMessageHash() {
        if (this.messageID == null || this.messageContent == null || this.messageContent.isEmpty()) {
            return "00:0:ERROR";
        }
        
        String firstTwoID = this.messageID.substring(0, 2);
        
        String[] words = this.messageContent.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        firstWord = firstWord.replaceAll("[^a-zA-Z0-9]", "");
        lastWord = lastWord.replaceAll("[^a-zA-Z0-9]", "");
        
        String combined = firstTwoID + ":" + this.numMessagesSent + ":" + firstWord + lastWord;
        return combined.toUpperCase();
    }

    public String SentMessage(int choice) {
        switch(choice) {
            case 1:
                totalMessagesSentCount++; 
                return "Message successfully sent.";
            case 2:
                return "Press 0 to delete the message.";
            case 3:
                return "Message successfully stored.";
            default:
                return "Invalid choice option.";
        }
    }

    public String printMessages() {
        return "Message ID: " + this.messageID + "\n" +
               "Message Hash: " + this.messageHash + "\n" +
               "Recipient: " + this.recipientNumber + "\n" +
               "Message: " + this.messageContent;
    }

    public int returnTotalMessagess() {
        return totalMessagesSentCount;
    }
    
    public void storeMessage() {
        System.out.println("JSON storage feature is being simulated.");
    }

    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
}