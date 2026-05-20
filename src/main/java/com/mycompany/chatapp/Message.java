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
    // Fields required to track message properties
    private String messageID;
    private int numMessagesSent; // Tracks sequence index of the message
    private String recipientNumber;
    private String messageContent;
    private String messageHash;
    
    // Static tracker to keep count of ALL successfully sent messages across the application
    private static int totalMessagesSentCount = 0;

    // Constructor
    public Message(int numMessagesSent, String recipientNumber, String messageContent) {
        this.numMessagesSent = numMessagesSent;
        this.recipientNumber = recipientNumber;
        this.messageContent = messageContent;
        
        // Auto-generate ID and Hash during instantiation
        this.messageID = generateRandomMessageID();
        this.messageHash = createMessageHash();
    }

    // Helper to generate a random 10-digit unique tracking number
    private String generateRandomMessageID() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(rand.nextInt(10));
        }
        return sb.toString();
    }

    // 1. Method to check if Message ID meets criteria (not more than 10 characters)
    public boolean checkMessageID() {
        return this.messageID != null && this.messageID.length() <= 10;
    }

    // 2. Method to check and format recipient cell number
    public String checkRecipientCell(String phoneNumber) {
        // Validation rule: Must start with international code (e.g., +27 or look for +) and no more than 10 trailing characters long (excluding +)
        if (phoneNumber != null && phoneNumber.startsWith("+") && phoneNumber.length() <= 13) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    // 3. Method to build the Message Hash
    public String createMessageHash() {
        if (this.messageID == null || this.messageContent == null || this.messageContent.isEmpty()) {
            return "00:0:ERROR";
        }
        
        // First two numbers of message ID
        String firstTwoID = this.messageID.substring(0, 2);
        
        // The message number sequence string
        String msgNumStr = String.valueOf(this.numMessagesSent);
        
        // First and last words of the message text
        String[] words = this.messageContent.trim().split("\\s+");
        String firstWord = words[0];
        String lastWord = words[words.length - 1];
        
        // Combine in format: 00:0:HITHANKS (All Caps)
        String combined = firstTwoID + ":" + msgNumStr + ":" + firstWord + lastWord;
        return combined.toUpperCase();
    }

    // 4. Method to handle the sending choice output string
    public String SentMessage(int choice) {
        switch(choice) {
            case 1:
                totalMessagesSentCount++; // Accumulate to system total
                return "Message successfully sent";
            case 2:
                return "Press 0 to delete the message";
            case 3:
                return "Message successfully stored";
            default:
                return "Invalid choice option.";
        }
    }

    // 5. Method to return structured summary string
    public String printMessages() {
        return "Message ID: " + this.messageID + "\n" +
               "Message Hash: " + this.messageHash + "\n" +
               "Recipient: " + this.recipientNumber + "\n" +
               "Message: " + this.messageContent;
    }

    // 6. Method to return total accumulated messages sent application-wide
    public int returnTotalMessagess() {
        return totalMessagesSentCount;
    }
    
    // Research requirement placeholder: Stub method for storing messages to JSON format
    public void storeMessage() {
        // TODO: Implement JSON parsing/writing logic using a library like Gson or minimal custom file writing
        System.out.println("JSON storage feature is being simulated.");
    }

    // Getters for testing verification
    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
}
