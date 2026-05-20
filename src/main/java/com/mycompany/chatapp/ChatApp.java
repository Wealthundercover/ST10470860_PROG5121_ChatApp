/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;
import java.util.Scanner;
/**
 *
 * @author Ngcebo
 */

public class ChatApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login loginProcessor = new Login();

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
                System.out.println("\nWelcome to QuickChat.");
                
                int menuChoice = 0;
                int messageCounter = 0; 

                while (menuChoice != 3) {
                    System.out.println("\nPlease choose one of the following features from the menu:");
                    System.out.println("1) Send Messages");
                    System.out.println("2) Show recently sent messages");
                    System.out.println("3) Quit");
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
        
    
