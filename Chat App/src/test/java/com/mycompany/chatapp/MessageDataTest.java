/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.chatapp;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
/**
 *
 * @author Ngcebo
 */

public class MessageDataTest {

    // Helper utility initializer to setup exact values from assignment rubric documentation sheet
    private MessageData runEnvironmentInitialization() {
        MessageData tracker = new MessageData();
        // Populating array models cleanly using specified data attributes
        tracker.captureMessageRecord("+27834557896", "01:0:CAKE", "Did you get the cake?", 1); // Sent
        tracker.captureMessageRecord("+27838884567", "02:1:WHERE", "Where are you? You are late! I have asked you to be on time.", 3); // Stored
        tracker.captureMessageRecord("+27834484567", "03:2:YOHOO", "Yohoooo, I am at your gate.", 2); // Disregard
        tracker.captureMessageRecord("0838884567", "04:3:DINNER", "It is dinner time !", 1); // Sent
        tracker.captureMessageRecord("+27838884567", "05:4:LEAVE", "Ok, I am leaving without you.", 3); // Stored
        return tracker;
    }

    @Test
    public void testSentMessagesArrayCorrectlyPopulated() {
        MessageData tracker = runEnvironmentInitialization();
        // Asserting that specific index pointers catch correctly formatted strings
        assertEquals("Did you get the cake?", tracker.sentMessages[0]);
        assertEquals("It is dinner time !", tracker.sentMessages[3]);
    }

    @Test
    public void testDisplayLongestMessage() {
        MessageData tracker = runEnvironmentInitialization();
        String targetMaxStr = "Where are you? You are late! I have asked you to be on time.";
        assertEquals(targetMaxStr, tracker.getLongestStoredMessage());
    }

    @Test
    public void testSearchByMessageID() {
        MessageData tracker = runEnvironmentInitialization();
        String searchResult = tracker.searchByMessageID("0838884567");
        assertNotNull(searchResult);
        assertTrue(searchResult.contains("It is dinner time !"));
    }

    @Test
    public void testSearchAllByRecipient() {
        MessageData tracker = runEnvironmentInitialization();
        ArrayList<String> matches = tracker.searchAllMessagesForRecipient("+27838884567");
        
        assertEquals(2, matches.size());
        assertTrue(matches.contains("Where are you? You are late! I have asked you to be on time."));
        assertTrue(matches.contains("Ok, I am leaving without you."));
    }

    @Test
    public void testDeleteMessageUsingHash() {
        MessageData tracker = runEnvironmentInitialization();
        
        // Target: delete message index matching transaction hash data value 02:1:WHERE
        boolean flagOutput = tracker.deleteMessageByHash("02:1:WHERE");
        assertTrue(flagOutput);
        assertNull(tracker.messageHashes[1]); // Verification checkpoint
    }
}