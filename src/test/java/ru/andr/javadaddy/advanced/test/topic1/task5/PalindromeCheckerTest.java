package ru.andr.javadaddy.advanced.test.topic1.task5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.andr.javadaddy.advanced.test.topic1.task5.PalindromeChecker.isPalindrome;

class PalindromeCheckerTest {

    @Test
    void isPalindrome_success() {
        assertTrue(isPalindrome("madam"));
    }

    @Test
    void isPalindromeUpperLowerCase_success() {
        assertTrue(isPalindrome("Madam"));
    }

    @Test
    void isPalindromeTextWithSpaces_success() {
        assertTrue(isPalindrome("Mada m  adam"));
    }

    @Test
    void isPalindromeEmptyText_success() {
        assertThrows(IllegalArgumentException.class, () -> isPalindrome(""));
    }
}
