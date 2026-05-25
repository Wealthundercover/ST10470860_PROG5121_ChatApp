# ChatApp - Part 1 & Part 2: Integrated System
**Developer:** Ngcebo Magagula
**Project Version:** 1.0.0
**Date:** May 2026

## 1. Project Overview
This Java-based Chat Application integrates a secure **User Authentication System** (Part 1) with an advanced **QuickChat Messaging Module** (Part 2). The application enforces strict data integrity constraints across registration, login flows, and active user session tasks.

The project is built using a **Modular Design** pattern to ensure a clean separation between the user interface (Console), the core business logic (Validation classes), and quality assurance (Unit Testing).

---

## 2. Feature Implementation

### Part 1: Authentication Logic
I have implemented specific validation logic to ensure that user data meets high security and formatting standards:

| Feature | Requirement | Logic Implementation |
| :--- | :--- | :--- |
| **Username** | Underscore + Max 5 chars | `checkUserName()` ensures the username contains `_` and validates length. |
| **Password** | Complexity Rules | `checkPasswordComplexity()` verifies at least 8 chars, one uppercase, one digit, and one special character. |
| **Phone Number** | SA Format | `checkCellPhoneNumber()` validates the `+27` prefix and length limit. |
| **Authentication**| Secure Login | `loginUser()` performs a secure equality check against stored credentials. |

### Part 2: Messaging Logic
The messaging module adds functional tracking, strict string verification routines, and custom identification formatting:

| Feature | Requirement | Logic Implementation |
| :--- | :--- | :--- |
| **Recipient Cell** | Format Validation | `checkRecipientCell()` verifies that recipient numbers include an international code and prefix (`+27`). |
| **Message Content**| Max 250 Characters | The console terminal loop checks string length boundaries and reports the exact count of overflow characters. |
| **Message Hash** | Custom Compilation | `createMessageHash()` generates an uppercase transaction code merging the ID prefix, step counter, and text boundary markers. |
| **Metric Tracking**| Global Total | `returnTotalMessagess()` accesses a static internal session tracker to display cumulative messages sent. |

---

## 3. How to Run the Application
1. **Open the Project:** Load the `com.mycompany.chatapp` package into NetBeans IDE while on the `KhanbanTasks` branch.
2. **Compile:** Run a `Clean and Build` on the project (`Shift + F11`).
3. **Execute Main:** Run `ChatApp.java` to start the terminal menu system.
4. **Authenticate & Navigate:** Register and log in using valid criteria to unlock the primary messaging application menu workspace.
5. **Run Tests:** Press `Alt + F6` or right-click the project folder and select **Test** to run all automated JUnit checking frameworks simultaneously.

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
* **Oracle.** 2026. *Class String*. [Online]. Available at: https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html [Accessed 13 April 2026].
* **Vogel, L.** 2021. *Unit Testing with JUnit - Tutorial*. [Online]. Available at: https://www.vogella.com/tutorials/JUnit/article.html [Accessed 13 April 2026].
* **Deitel, P.J. & Deitel, H.M.** 2020. *Java How to Program, Late Objects*. 11th ed. New York: Pearson. [Accessed 22 May 2026].
* **Horstmann, C.S.** 2023. *Core Java Volume I–Fundamentals*. 12th ed. Boston: Prentice Hall. [Accessed 22 May 2026].
* **Massol, V. & Dai, T.** 2024. *JUnit in Action*. 3rd ed. Greenwich: Manning Publications. [Accessed 22 May 2026].
