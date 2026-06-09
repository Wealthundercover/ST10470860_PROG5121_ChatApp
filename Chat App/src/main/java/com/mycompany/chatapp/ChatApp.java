/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.Scanner;
import java.util.ArrayList;
/**
 *
 * @author Ngcebo
 */

public class ChatApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login loginProcessor = new Login();
        // Instantiate Part 3 storage engine instance coordinator right here!
        MessageData dataEngine = new MessageData();

        System.out.println("--- USER REGISTRATION ---");
        System.out.print("Enter First Name: ");
        String fName = input.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();
        
        System.out.print("Please provide a username: ");
        String user = input.nextLine();
        
        System.out.print("Enter Password: ");
        String pass = input.nextLine();
        
        System.out.print("Enter Phone (+27...): ");
        String phone = input.nextLine();

        String regStatus = loginProcessor.registerUser(user, pass, phone, fName, lName);
        System.out.println("\n" + regStatus);

        if (regStatus.contains("successfully captured")) {
            System.out.println("\n--- LOGIN ---");
            System.out.print("Enter Username: ");
            String logUser = input.nextLine();
            
            System.out.print("Enter Password: ");
            String logPass = input.nextLine();

            boolean isLoginSuccessful = loginProcessor.loginUser(logUser, logPass);
            System.out.println(loginProcessor.returnLoginStatus(isLoginSuccessful));
            
            if (isLoginSuccessful) {
                System.out.println("\n=======================================");
                System.out.println("        WELCOME TO QUICKCHAT          ");
                System.out.println("=======================================");
                
                int menuChoice = 0;
                int messageCounter = 0; 

                while (menuChoice != 5) {
                    System.out.println("\nPlease choose one of the following features from the menu:");
                    System.out.println("1) Send Messages");
                    System.out.println("2) Show recently sent messages");
                    System.out.println("3) Display Full System Task Report (Quick Print)");
                    System.out.println("4) Stored Messages (Part 3 Sub-Menu Workspace)");
                    System.out.println("5) Quit");
                    System.out.print("Enter choice numeric value: ");
                    
                    if (input.hasNextInt()) {
                        menuChoice = input.nextInt();
                        input.nextLine(); 
                    } else {
                        System.out.println("Invalid numeric input. Please try again.");
                        input.nextLine(); 
                        continue;
                    }

                    switch (menuChoice) {
                        case 1:
                            System.out.print("How many messages do you wish to enter? ");
                            int limit = 0;
                            if (input.hasNextInt()) {
                                limit = input.nextInt();
                                input.nextLine(); 
                            } else {
                                System.out.println("Invalid number. Returning to main menu.");
                                input.nextLine();
                                break;
                            }
                            
                            for (int i = 0; i < limit; i++) {
                                System.out.println("\n--- Entering Details for Message " + (i + 1) + " ---");
                                
                                String phoneStatus = "";
                                String recipientNum = "";
                                while (true) {
                                    System.out.print("Enter Recipient Cell Number (e.g., +27718693002): ");
                                    recipientNum = input.nextLine();
                                    
                                    Message tempCheck = new Message(messageCounter, recipientNum, "Test");
                                    phoneStatus = tempCheck.checkRecipientCell(recipientNum);
                                    System.out.println(phoneStatus);
                                    
                                    if (phoneStatus.contains("successfully captured")) {
                                        break;
                                    }
                                }
                                
                                String msgContent = "";
                                while (true) {
                                    System.out.print("Enter your message content: ");
                                    msgContent = input.nextLine();
                                    
                                    if (msgContent.length() <= 250) {
                                        System.out.println("Message ready to send.");
                                        break;
                                    } else {
                                        int excess = msgContent.length() - 250;
                                        System.out.println("Message exceeds 250 characters by " + excess + " characters; please reduce the size.");
                                    }
                                }
                                
                                Message currentMsg = new Message(messageCounter, recipientNum, msgContent);
                                messageCounter++; 
                                
                                System.out.println("Message ID generated: <" + currentMsg.getMessageID() + ">");
                                
                                System.out.println("\nWhat would you like to do with this message?");
                                System.out.println("1) Send Message");
                                System.out.println("2) Disregard Message");
                                System.out.println("3) Store Message to send later");
                                System.out.print("Select choice (1-3): ");
                                
                                int actionChoice = 0;
                                if (input.hasNextInt()) {
                                    actionChoice = input.nextInt();
                                    input.nextLine(); 
                                }
                                
                                String deliveryReceipt = currentMsg.SentMessage(actionChoice);
                                System.out.println(deliveryReceipt);
                                
                                // NEW: Dynamically capture data to our parallel tracking arrays (no hardcoding values!)
                                dataEngine.captureMessageRecord(recipientNum, currentMsg.getMessageHash(), msgContent, actionChoice);
                                
                                System.out.println("\n=== Full Message Submission Details ===");
                                System.out.println(currentMsg.printMessages());
                                System.out.println("=======================================");
                                
                                System.out.println("Total global sent messages tracked: " + currentMsg.returnTotalMessagess());
                            }
                            break;
                            
                        case 2:
                            System.out.println("Coming Soon.");
                            break;
                            
                        case 3:
                            dataEngine.renderSystemReport();
                            break;
                            
                        case 4:
                            // PART 3 - Dynamic Interactive Sub-Menu loop execution interface handler workspace
                            boolean exitSub = false;
                            while (!exitSub) {
                                System.out.println("\n--- STORED MESSAGES MANAGEMENT DASHBOARD ---");
                                System.out.println("a) Display the sender and recipient of all stored messages");
                                System.out.println("b) Display the longest stored message");
                                System.out.println("c) Search for a message ID and display details");
                                System.out.println("d) Search for all messages stored for a particular recipient");
                                System.out.println("e) Delete a message using the message hash string");
                                System.out.println("f) Display full details report summary");
                                System.out.println("g) Return to Main Core Application Loop");
                                System.out.print("Select execution query option (a-g): ");
                                String subChoice = input.nextLine().toLowerCase().trim();

                                switch (subChoice) {
                                    case "a":
                                        dataEngine.printStoredRecipients();
                                        break;
                                    case "b":
                                        System.out.println("\nLongest Text Sequence Captured: \"" + dataEngine.getLongestStoredMessage() + "\"");
                                        break;
                                    case "c":
                                        System.out.print("Enter Target ID/Recipient Number to query: ");
                                        String queryID = input.nextLine();
                                        String resultC = dataEngine.searchByMessageID(queryID);
                                        System.out.println(resultC != null ? "\nResult Match -> " + resultC : "\nNo operational records found matching ID.");
                                        break;
                                    case "d":
                                        System.out.print("Enter target recipient mobile string: ");
                                        String recTarget = input.nextLine();
                                        ArrayList<String> recordsFound = dataEngine.searchAllMessagesForRecipient(recTarget);
                                        if(!recordsFound.isEmpty()) {
                                            System.out.println("\nCaptured Messages linked to target destination values:");
                                            for(String s : recordsFound) System.out.println("-> " + s);
                                        } else {
                                            System.out.println("\nNo logged occurrences matches matching entry patterns.");
                                        }
                                        break;
                                    case "e":
                                        System.out.print("Enter exact unique transaction hash string to clear: ");
                                        String hashInput = input.nextLine();
                                        boolean isRemoved = dataEngine.deleteMessageByHash(hashInput);
                                        System.out.println(isRemoved ? "\nEntry successfully deleted from indexes." : "\nHash target identity match error.");
                                        break;
                                    case "f":
                                        dataEngine.renderSystemReport();
                                        break;
                                    case "g":
                                        exitSub = true;
                                        break;
                                    default:
                                        System.out.println("Unknown sub-menu key identifier entered.");
                                }
                            }
                            break;
                            
                        case 5:
                            System.out.println("Exiting QuickChat application. Goodbye!");
                            break;
                            
                        default:
                            System.out.println("Invalid selection option chosen. Please re-select from list menu options.");
                    }
                }
            }
        }
        input.close();
    }
}