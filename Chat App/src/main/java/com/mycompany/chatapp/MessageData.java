/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;
import java.util.ArrayList;
/**
 *
 * @author Ngcebo
 */


public class MessageData {
    // parallel arrays architecture with an explicit upper bound 
    private static final int MAX_SIZE = 100;
    
    public String[] sentMessages = new String[MAX_SIZE];
    public String[] disregardedMessages = new String[MAX_SIZE];
    public String[] storedMessages = new String[MAX_SIZE];
    public String[] messageHashes = new String[MAX_SIZE];
    public String[] messageIDs = new String[MAX_SIZE]; 
    public String[] messageFlags = new String[MAX_SIZE]; // Track state: "Sent", "Disregard", or "Stored"
    
    public int totalRecordCount = 0;

    
    public void captureMessageRecord(String msgId, String hash, String content, int userActionChoice) {
        if (totalRecordCount >= MAX_SIZE) return;

        messageIDs[totalRecordCount] = msgId;
        messageHashes[totalRecordCount] = hash;

        
        if (userActionChoice == 1) {
            sentMessages[totalRecordCount] = content;
            messageFlags[totalRecordCount] = "Sent";
        } else if (userActionChoice == 2) {
            disregardedMessages[totalRecordCount] = content;
            messageFlags[totalRecordCount] = "Disregard";
        } else if (userActionChoice == 3) {
            storedMessages[totalRecordCount] = content;
            messageFlags[totalRecordCount] = "Stored";
        }
        totalRecordCount++;
    }

    // Display sender and recipient details of all stored messages
    public void printStoredRecipients() {
        System.out.println("\n--- All Stored / Logged Message Destinations ---");
        boolean hasRecords = false;
        for (int i = 0; i < totalRecordCount; i++) {
            if (messageIDs[i] != null) {
                System.out.println("Record [" + (i + 1) + "] -> Recipient ID / Number: " + messageIDs[i]);
                hasRecords = true;
            }
        }
        if (!hasRecords) System.out.println("No records found in storage layers.");
    }

    // Display longest stored message text sequence string
    public String getLongestStoredMessage() {
        String longestMsg = "";
        for (int i = 0; i < totalRecordCount; i++) {
            String activeMessage = getSafeMessageContent(i);
            if (activeMessage != null && activeMessage.length() > longestMsg.length()) {
                longestMsg = activeMessage;
            }
        }
        return longestMsg.isEmpty() ? "No messages available." : longestMsg;
    }

    
    public String searchByMessageID(String searchID) {
        for (int i = 0; i < totalRecordCount; i++) {
            if (messageIDs[i] != null && messageIDs[i].equals(searchID)) {
                return "Recipient: " + messageIDs[i] + " | Message: \"" + getSafeMessageContent(i) + "\"";
            }
        }
        return null;
    }

    
    public ArrayList<String> searchAllMessagesForRecipient(String recipientTarget) {
        ArrayList<String> matchingList = new ArrayList<>();
        for (int i = 0; i < totalRecordCount; i++) {
            if (messageIDs[i] != null && messageIDs[i].equals(recipientTarget)) {
                matchingList.add(getSafeMessageContent(i));
            }
        }
        return matchingList;
    }

    
    public boolean deleteMessageByHash(String targetHash) {
        for (int i = 0; i < totalRecordCount; i++) {
            if (messageHashes[i] != null && messageHashes[i].equalsIgnoreCase(targetHash)) {
                // Clear parallel index entries back to null state values
                messageIDs[i] = null;
                messageHashes[i] = null;
                messageFlags[i] = null;
                sentMessages[i] = null;
                disregardedMessages[i] = null;
                storedMessages[i] = null;
                return true;
            }
        }
        return false;
    }

    
    public void renderSystemReport() {
        System.out.println("\n================================== SYSTEM TASK REPORT ==================================");
        System.out.printf("%-15s %-18s %-12s %-40s\n", "HASH", "RECIPIENT ID", "STATUS", "MESSAGE TEXT");
        System.out.println("----------------------------------------------------------------------------------------");
        for (int i = 0; i < totalRecordCount; i++) {
            if (messageHashes[i] != null) {
                System.out.printf("%-15s %-18s %-12s %-40s\n", 
                        messageHashes[i], messageIDs[i], messageFlags[i], getSafeMessageContent(i));
            }
        }
        System.out.println("========================================================================================");
    }

    // Internal safety structural parsing handler utility to match context strings safely
    private String getSafeMessageContent(int index) {
        if (sentMessages[index] != null) return sentMessages[index];
        if (storedMessages[index] != null) return storedMessages[index];
        if (disregardedMessages[index] != null) return disregardedMessages[index];
        return "";
    }
}