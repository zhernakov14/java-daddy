package ru.andr.javadaddy.advanced.test.topic1.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.andr.javadaddy.advanced.test.topic1.task1.DivisionCalculator.divide;

class DivisionCalculatorTest {

    @Test
    void divide_success() {
        assertEquals(20, divide(100, 5));
    }

    @Test
    void divideByZero_exception() {
        assertThrows(ArithmeticException.class, () -> divide(100, 0));
    }
}
