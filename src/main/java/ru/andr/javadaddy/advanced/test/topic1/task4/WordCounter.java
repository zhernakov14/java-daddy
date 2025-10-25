package ru.andr.javadaddy.advanced.test.topic1.task4;

public class WordCounter {

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("text is null or empty");
        }
        String trimmed = text.trim();
        if (trimmed.isEmpty()) {
            return 0;
        }
        return trimmed.split("\\s+").length;
    }
}
