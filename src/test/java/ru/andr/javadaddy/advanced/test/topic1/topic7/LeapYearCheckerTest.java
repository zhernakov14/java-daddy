package ru.andr.javadaddy.advanced.test.topic1.topic7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static ru.andr.javadaddy.advanced.test.topic1.task7.LeapYearChecker.isLeapYear;

class LeapYearCheckerTest {

    @Test
    void isLeapYear_leap() {
        assertTrue(isLeapYear(2000));
    }

    @Test
    void isLeapYear1900_notLeap() {
        assertFalse(isLeapYear(1900));
    }

    @Test
    void isLeapYear1600_leap() {
        assertTrue(isLeapYear(1600));
    }

    @Test
    void isLeapYseare_notLeap() {
        assertFalse(isLeapYear(2025));
    }
}
