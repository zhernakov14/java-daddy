package ru.andr.javadaddy.advanced.test.topic1.task5;

public class PalindromeChecker {
    public static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            throw new IllegalArgumentException("text is null or empty");
        }
        String textLowerCaseWithoutSpaces = text.toLowerCase().replaceAll("\\s+", "");
        String reversed = new StringBuilder(textLowerCaseWithoutSpaces).reverse().toString();
        return textLowerCaseWithoutSpaces.equals(reversed);
    }
}
