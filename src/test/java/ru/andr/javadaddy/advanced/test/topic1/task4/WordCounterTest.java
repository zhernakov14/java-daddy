package ru.andr.javadaddy.advanced.test.topic1.task4;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static ru.andr.javadaddy.advanced.test.topic1.task4.WordCounter.countWords;

class WordCounterTest {

    @Test
    void countWords_success() {
        String input = "Hello World";
        assertEquals(2, countWords(input));
    }

    @Test
    void countWordsEmptyInput_success() {
        String input = "";
        assertThrows(IllegalArgumentException.class, () -> countWords(input));
    }

    @Test
    void countWordsMultipleSpaces_success() {
        String input = "Hello   World";
        assertEquals(2, countWords(input));
    }

    @Test
    void countWordsMultiRow_success() {
        String input = "Hello \n World";
        assertEquals(2, countWords(input));
    }

    @Test
    void countWordsOnlySpaces_successs() {
        String input = "       ";
        assertEquals(0, countWords(input));
    }
}
