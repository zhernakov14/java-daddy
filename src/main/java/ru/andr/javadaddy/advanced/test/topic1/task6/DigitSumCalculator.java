package ru.andr.javadaddy.advanced.test.topic1.task6;

public class DigitSumCalculator {
    public static int sumDigits(int number) {
        String numStr = String.valueOf(Math.abs(number));
        int sum = 0;
        for (char digit : numStr.toCharArray()) {
            sum += digit - '0';
        }
        return sum;
    }
}
