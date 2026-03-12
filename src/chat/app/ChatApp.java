/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package chat.app;

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
        
        System.out.print("Enter Username: ");
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
        }
    }
}