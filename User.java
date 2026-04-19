/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.user;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class User {

    // Store registered user details
    static String storedUsername = "";
    static String storedPassword = "";
    static String storedFirstName = "";
    static String storedLastName = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // ===== REGISTRATION =====
        System.out.println("=== REGISTRATION ===");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter username (max 5 chars, must include _): ");
        String username = scanner.nextLine();

        System.out.print("Enter password (min 8 chars, capital, number, special char): ");
        String password = scanner.nextLine();

        System.out.print("Enter cell phone number (+27XXXXXXXXX): ");
        String cellPhone = scanner.nextLine();

        String result = registerUser(username, password, cellPhone, firstName, lastName);
        System.out.println("\n" + result);

        if (!result.contains("successful")) {
            System.out.println("Registration failed. Restart program.");
            return;
        }

        // ===== LOGIN =====
        boolean loggedIn = false;

        while (!loggedIn) {
            System.out.println("\n=== LOGIN ===");

            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            if (loginUser(loginUsername, loginPassword)) {
                System.out.println("Login successful! Welcome " + storedFirstName + " " + storedLastName);
                loggedIn = true;
            } else {
                System.out.println("Login failed! Try again.\n");
            }
        }

        scanner.close();
    }

    // Username check
    public static boolean checkUserName(String username) {
        return username.length() <= 5 && username.contains("_");
    }

    // Password check
    public static boolean checkPasswordComplexity(String password) {
        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            if (Character.isDigit(c)) hasNumber = true;
            if (!Character.isLetterOrDigit(c)) hasSpecial = true;
        }

        return password.length() >= 8 && hasUpper && hasNumber && hasSpecial;
    }

    // Phone check
    public static boolean checkCellPhoneNumber(String cellPhone) {
        return cellPhone.matches("^\\+27\\d{9}$");
    }

    // Register user
    public static String registerUser(String username, String password, String cellPhone, String firstName, String lastName) {

        if (!checkUserName(username)) {
            return "Username is incorrect.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is incorrect.";
        }

        if (!checkCellPhoneNumber(cellPhone)) {
            return "Cell number is incorrect.";
        }

        storedUsername = username;
        storedPassword = password;
        storedFirstName = firstName;
        storedLastName = lastName;

        return "Registration successful!";
    }

    // Login method
    public static boolean loginUser(String username, String password) {
        return username.equals(storedUsername) && password.equals(storedPassword);
    }
}
