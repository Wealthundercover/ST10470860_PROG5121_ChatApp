/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.chatapp;

/**
 *
 * @author Ngcebo
 */
import java.util.Scanner;

public class ChatApp {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login loginProcessor = new Login();

        System.out.println("--- USER REGISTRATION ---");
        System.out.print("Enter First Name: ");
        String fName = input.nextLine();
        
        System.out.print("Enter Last Name: ");
        String lName = input.nextLine();
        
        System.out.print("Please provide a username:");
        String user = input.nextLine();
        
        System.out.print("Enter Password: ");
        String pass = input.nextLine();
        
        System.out.print("Enter Phone (+27...): ");
        String phone = input.nextLine();

        // Validate Registration
        String regStatus = loginProcessor.registerUser(user, pass, phone, fName, lName);
        System.out.println("\n" + regStatus);

        // Only proceed to Login if registration succeeded
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
                int messageCounter = 0; // Tracks message index sequence

                // Loop runs continuously until user selects Option 3) Quit
                while (menuChoice != 3) {
                    System.out.println("\nPlease choose one of the following features from the menu:");
                    System.out.println("1) Send Messages");
                    System.out.println("2) Show recently sent messages");
                    System.out.println("3) Quit");
                    System.out.print("Enter choice numeric value: ");
                    
                    if (input.hasNextInt()) {
                        menuChoice = input.nextInt();
                        input.nextLine(); // Clear buffer
                    } else {
                        System.out.println("Invalid numeric input. Please try again.");
                        input.nextLine(); // Clear invalid token
                        continue;
                    }

                    switch (menuChoice) {
                        case 1:
                            System.out.print("How many messages do you wish to enter? ");
                            int limit = 0;
                            if (input.hasNextInt()) {
                                limit = input.nextInt();
                                input.nextLine(); // Clear buffer
                            } else {
                                System.out.println("Invalid number. Returning to main menu.");
                                input.nextLine();
                                break;
                            }
                            
                            // Loop to capture the set number of messages
                            for (int i = 0; i < limit; i++) {
                                System.out.println("\n--- Entering Details for Message " + (i + 1) + " ---");
                                
                                // Capture and validate Recipient Number
                                String phoneStatus = "";
                                String recipientNum = "";
                                while (true) {
                                    System.out.print("Enter Recipient Cell Number (e.g., +27718693002): ");
                                    recipientNum = input.nextLine();
                                    
                                    // Make a temporary object to run the assignment validation string check
                                    Message tempCheck = new Message(messageCounter, recipientNum, "Test");
                                    phoneStatus = tempCheck.checkRecipientCell(recipientNum);
                                    System.out.println(phoneStatus);
                                    
                                    if (phoneStatus.contains("successfully captured")) {
                                        break;
                                    }
                                }
                                
                                // Capture and validate Message text length constraints
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
                                
                                // Instantiate the real Message tracker object
                                Message currentMsg = new Message(messageCounter, recipientNum, msgContent);
                                messageCounter++; // Prep increment for next message index code
                                
                                System.out.println("Message ID generated: <" + currentMsg.getMessageID() + ">");
                                
                                // Display Action Prompt Selection Menu
                                System.out.println("\nWhat would you like to do with this message?");
                                System.out.println("1) Send Message");
                                System.out.println("2) Disregard Message");
                                System.out.println("3) Store Message to send later");
                                System.out.print("Select choice (1-3): ");
                                
                                int actionChoice = 0;
                                if (input.hasNextInt()) {
                                    actionChoice = input.nextInt();
                                    input.nextLine(); // Clear buffer
                                }
                                
                                // Output delivery process confirmation strings
                                String deliveryReceipt = currentMsg.SentMessage(actionChoice);
                                System.out.println(deliveryReceipt);
                                
                                // Print structured details layout summary block required by rubric
                                System.out.println("\n=== Full Message Submission Details ===");
                                System.out.println(currentMsg.printMessages());
                                System.out.println("=======================================");
                                
                                // Show global accumulation totals count status metrics update
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
        
    
