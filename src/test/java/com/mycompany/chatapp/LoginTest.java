package com.mycompany.chatapp;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginTest {
    
    Login login = new Login();

    @Test
    public void testCheckUserName() {
        // Test a valid username: contains _ and is <= 5 chars
        assertTrue(login.checkUserName("ky_le"));
        
        // Test invalid username: too long
        assertFalse(login.checkUserName("kylemarshall"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        // Test valid password: Capital, Number, Special, 8+ chars
        assertTrue(login.checkPasswordComplexity("Ch@tApp123"));
        
        // Test invalid password: No capital or special char
        assertFalse(login.checkPasswordComplexity("password123"));
    }
}