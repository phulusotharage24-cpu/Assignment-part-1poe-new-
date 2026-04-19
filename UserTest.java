/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.user;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author User
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    // ===== USERNAME TESTS =====
    @Test
    public void testValidUsername() {
        assertTrue(User.checkUserName("ab_cd"));
    }

    @Test
    public void testInvalidUsername_NoUnderscore() {
        assertFalse(User.checkUserName("abcd"));
    }

    @Test
    public void testInvalidUsername_TooLong() {
        assertFalse(User.checkUserName("abcdef_"));
    }

    // ===== PASSWORD TESTS =====
    @Test
    public void testValidPassword() {
        assertTrue(User.checkPasswordComplexity("Abcdef1!"));
    }

    @Test
    public void testInvalidPassword_NoCapital() {
        assertFalse(User.checkPasswordComplexity("abcdef1!"));
    }

    @Test
    public void testInvalidPassword_NoNumber() {
        assertFalse(User.checkPasswordComplexity("Abcdefg!"));
    }

    @Test
    public void testInvalidPassword_NoSpecialChar() {
        assertFalse(User.checkPasswordComplexity("Abcdefg1"));
    }

    @Test
    public void testInvalidPassword_TooShort() {
        assertFalse(User.checkPasswordComplexity("Ab1!"));
    }

    // ===== CELL NUMBER TESTS =====
    @Test
    public void testValidCellNumber() {
        assertTrue(User.checkCellPhoneNumber("+27123456789"));
    }

    @Test
    public void testInvalidCellNumber_WrongFormat() {
        assertFalse(User.checkCellPhoneNumber("0123456789"));
    }

    @Test
    public void testInvalidCellNumber_TooShort() {
        assertFalse(User.checkCellPhoneNumber("+2712345678"));
    }

    // ===== REGISTRATION TEST =====
    @Test
    public void testSuccessfulRegistration() {
        String result = User.registerUser("ab_cd", "Abcdef1!", "+27123456789", "John", "Doe");
        assertEquals("Registration successful!", result);
    }

    @Test
    public void testFailedRegistration_InvalidUsername() {
        String result = User.registerUser("abcd", "Abcdef1!", "+27123456789", "John", "Doe");
        assertEquals("Username is incorrect.", result);
    }

    // ===== LOGIN TEST =====
    @Test
    public void testLoginSuccess() {
        User.registerUser("ab_cd", "Abcdef1!", "+27123456789", "John", "Doe");
        assertTrue(User.loginUser("ab_cd", "Abcdef1!"));
    }

    @Test
    public void testLoginFailure() {
        User.registerUser("ab_cd", "Abcdef1!", "+27123456789", "John", "Doe");
        assertFalse(User.loginUser("wrong", "wrong"));
    }
}