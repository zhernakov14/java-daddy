package ru.andr.javadaddy.advanced.test.topic1.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.andr.javadaddy.advanced.test.topic1.task2.MaxFinder.findMax;

class MaxFinderTest {

    @Test
    void arrayWithOneElement_success() {
        assertEquals(1, findMax(new int[]{1}));
    }

    @Test
    void arrayWithNegativeElements_success() {
        assertEquals(-15, findMax(new int[]{-132, -33, -15, -87}));
    }

    @Test
    void arrayWithDuplicateElements_success() {
        assertEquals(-15, findMax(new int[]{-132, -15, -15, -87, Integer.MIN_VALUE}));
    }

    @Test
    void emptyArray_exception() {
        assertThrows(IllegalArgumentException.class, () -> findMax(new int[0]));
    }
}
