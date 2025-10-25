package ru.andr.javadaddy.advanced.test.topic1.task7;

public class LeapYearChecker {
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}
