package ru.andr.javadaddy.advanced.test.topic1.task1;

public class DivisionCalculator {
    public static double divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Деление на ноль");
        }
        return (double) a / b;
    }
}
