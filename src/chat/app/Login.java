/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chat.app;

public class Login {

    // Variables to store user data after registration
    private String registeredUsername;
    private String registeredPassword;
    private String firstName;
    private String lastName;

    // Method to check if username contains "_" and is <= 5 chars
    public boolean checkUserName(String username) {
        return username.contains("_") && username.length() <= 5;
    }

    // Method to check password complexity
    public boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasNum = false;
        boolean hasSpecial = false;
        String specialChars = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        if (password.length() < 8) return false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasNum = true;
            if (specialChars.contains(String.valueOf(c))) {
                hasSpecial = true;
            }
        }
        return hasUpper && hasNum && hasSpecial;
    }

    // Method to check South African phone number
    public boolean checkCellPhoneNumber(String phoneNumber) {
        // Starts with +27 and max 10 digits after (total 13)
        return phoneNumber.startsWith("+27") && phoneNumber.length() <= 13;
    }

    // Method to register user and return the required POE messages
    public String registerUser(String user, String pass, String phone, String fName, String lName) {
        if (!checkUserName(user)) {
            return "Username is not correctly formatted please ensure that your username contains an underscore and is no more than five characters in length.";
        }
        
        if (!checkPasswordComplexity(pass)) {
            return "Password is not correctly formatted please ensure that your password contains atleast eight characters a capital letter a number and a special character.";
        }

        if (!checkCellPhoneNumber(phone)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        // Save data to the class variables
        this.registeredUsername = user;
        this.registeredPassword = pass;
        this.firstName = fName;
        this.lastName = lName;

        return "Username successfully captured\nPassword successfully captured\nCell phone number successfully added.";
    }

    // Method to verify login details
    public boolean loginUser(String user, String pass) {
        return user.equals(registeredUsername) && pass.equals(registeredPassword);
    }

    // Method to return login status message
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + ", " + lastName + " it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}