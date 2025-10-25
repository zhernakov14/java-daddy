package ru.andr.javadaddy.advanced.test.topic1.task6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.andr.javadaddy.advanced.test.topic1.task6.DigitSumCalculator.sumDigits;

class DigitSumCalculatorTest {

    @Test
    void sumDigitsSingleDigitNumber_success() {
        assertEquals(5, sumDigits(5));
    }

    @Test
    void sumDigitsMultiDigitNumber_success() {
        assertEquals(5, sumDigits(122));
    }

    @Test
    void sumDigitsNegativeNumber_success() {
        assertEquals(5, sumDigits(-122));
    }

    @Test
    void sumDigitsZero_success() {
        assertEquals(0, sumDigits(0));
    }
}
