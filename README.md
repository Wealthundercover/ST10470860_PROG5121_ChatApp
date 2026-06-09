# ChatApp - Part 1, Part 2 & Part 3: Fully Integrated Production System
**Developer:** Ngcebo Magagula
**Project Version:** 1.0.0
**Date:** June 2026

## 1. Project Overview
This Java-based Chat Application seamlessly integrates a secure **User Authentication System** (Part 1), an advanced **QuickChat Messaging Module** (Part 2), and a fully dynamic **Parallel Array Data Engine & Reporting Dashboard** (Part 3). The application enforces strict data integrity constraints across registration, login flows, active session message capturing, and administrative reporting tasks.

The project utilizes a **Modular Design** and **Data Coordinator Class** pattern to ensure clean separation of concerns between the user interface (Console loops), core data processing logic (`MessageData` class), validation engines, and automated quality assurance framework (JUnit Test Suites).

---

## 2. Feature Implementation

### Part 1: Authentication Logic
I have implemented specific validation logic to ensure that user data meets high security and formatting standards:

| Feature | Requirement | Logic Implementation |
| :--- | :--- | :--- |
| **Username** | Underscore + Max 5 chars | `checkUserName()` ensures the username contains `_` and validates length boundaries. |
| **Password** | Complexity Rules | `checkPasswordComplexity()` verifies at least 8 chars, one uppercase, one digit, and one special character. |
| **Phone Number** | SA Format | `checkCellPhoneNumber()` validates the `+27` prefix and length limit constraints. |
| **Authentication**| Secure Login | `loginUser()` performs a secure equality check against stored registration state parameters. |

### Part 2: Messaging Logic
The messaging module adds functional tracking, strict string verification routines, and custom identification formatting:

| Feature | Requirement | Logic Implementation |
| :--- | :--- | :--- |
| **Recipient Cell** | Format Validation | `checkRecipientCell()` verifies that recipient numbers include an international code and prefix (`+27`). |
| **Message Content**| Max 250 Characters | The console terminal loop checks string length boundaries and reports the exact count of overflow characters. |
| **Message Hash** | Custom Compilation | `createMessageHash()` generates an uppercase transaction code merging the ID prefix, step counter, and text boundary markers. |
| **Metric Tracking**| Global Total | `returnTotalMessagess()` accesses a static internal session tracker to display cumulative messages sent. |

### Part 3: Parallel Array Storage Architecture & Dashboard Menu
Part 3 replaces simulated endpoints with active primary-memory database management matrices. Five matching parallel arrays track indices across dynamic runtime states:

| Feature | Technical Architecture / Logic Implementation |
| :--- | :--- |
| **Parallel Storage Engine** | Uses a dedicated coordinator layer (`MessageData.java`) holding structural arrays for `sentMessages`, `disregardedMessages`, `storedMessages`, `messageHashes`, and `messageIDs` sharing identical index offsets. |
| **Option A: Stored Destinations**| `printStoredRecipients()` loops through live arrays to instantly map and display all tracked recipient mobile identity markers. |
| **Option B: Max String Analysis**| `getLongestStoredMessage()` uses a structural maximum-search iteration algorithm to find and output the message string with the largest length property. |
| **Option C: Targeted ID Query** | `searchByMessageID()` uses a string equality search to match a target ID, instantly returning the recipient number paired with its text body content. |
| **Option D: Recipient Filtering** | `searchAllMessagesForRecipient()` filters the array indices to isolate, extract, and build a collection of all textual occurrences assigned to a specific target phone number. |
| **Option E: Record Deletion** | `deleteMessageByHash()` performs clean record nullification at the matching hash position, wiping entries safely from the system framework indexes. |
| **Option F: Tabular Reporting** | `renderSystemReport()` uses clean formatting statements (`System.out.printf`) to generate a professional, structured system summary tracking hashes, IDs, statuses, and text clips. |

---

## 3. How to Run the Application
1. **Open the Project:** Load the `com.mycompany.chatapp` package into NetBeans IDE while checked into the **`KhanbanTasks`** branch.
2. **Compile:** Run a `Clean and Build` on the project (`Shift + F11`).
3. **Execute Main:** Run `ChatApp.java` to start the terminal menu system.
4. **Authenticate & Navigate:** Register and log in using valid criteria to unlock the primary messaging application menu workspace.
5. **Explore Sub-Menu Dashboard:** Select **Option 4** from the main menu loop to branch into the interactive **Stored Messages Report Dashboard (Part 3 Sub-Menu)** workspace to execute searches, run reports, and process array deletions.
6. **Run Tests:** Press **`Alt + F6`** or right-click the project folder and select **Test** to run all automated JUnit checking frameworks simultaneously to verify the code passes the rubric's sample data parameters.

## 📺 Project Presentation
You can watch the full technical walkthrough and demonstration of this application on YouTube:
## PART 1
**Link:** [Watch the Presentation Here](https://youtu.be/6yxX21c1gg4)

## PART 2
**Link:** [Watch the presentation Here](https://youtu.be/_8gT-BJGN58?si=PC5MVN4LDJ2VdY8q)

---

## 4. References (Harvard Style)
* **Bloch, J.** 2018. *Effective Java*. 3rd ed. Boston: Addison-Wesley.
* **Deitel, P.J. & Deitel, H.M.** 2017. *Java: How to Program, Early Objects*. 11th ed. Upper Saddle River: Pearson Education.
* **Deitel, P.J. & Deitel, H.M.** 2020. *Java How to Program, Late Objects*. 11th ed. New York: Pearson. [Accessed 22 May 2026].
* **Gaddis, T.** 2023. *Starting Out with Java: From Control Structures through Objects*. 8th ed. Boston: Pearson. [Accessed 09 June 2026].
* **Horstmann, C.S.** 2023. *Core Java Volume I–Fundamentals*. 12th ed. Boston: Prentice Hall. [Accessed 22 May 2026].
* **Liang, Y.D.** 2024. *Introduction to Java Programming and Data Structures*. 13th ed. London: Pearson. [Accessed 09 June 2026].
* **Massol, V. & Dai, T.** 2024. *JUnit in Action*. 3rd ed. Greenwich: Manning Publications. [Accessed 22 May 2026].
* **Oracle.** 2026. *Class String*. [Online]. Available at: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html [Accessed 13 April 2026].
* **Oracle.** 2026. *Arrays Tutorial*. [Online]. Available at: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html [Accessed 09 June 2026].
* **Vogel, L.** 2021. *Unit Testing with JUnit - Tutorial*. [Online]. Available at: https://www.vogella.com/tutorials/JUnit/article.html [Accessed 13 April 2026].
