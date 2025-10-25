package ru.andr.javadaddy.advanced.test.topic1.task3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.andr.javadaddy.advanced.test.topic1.task3.PasswordValidator.isValid;

class PasswordValidatorTest {

    @Test
    void passwordIsShorterThan8Characters_notValid() {
        assertFalse(isValid("111"));
    }

    @Test
    void passwordWithoutDigits_notValid() {
        assertFalse(isValid("asdasdasd"));
    }

    @Test
    void passwordWithoutDigits_valid() {
        assertTrue(isValid("asdasdasd1"));
    }

    @Test
    void passwordIsEmpty_notValid() {
        assertFalse(isValid(""));
    }

    @Test
    void passwordIsNull_exception() {
        assertThrows(IllegalArgumentException.class, () -> isValid(null));
    }
}
