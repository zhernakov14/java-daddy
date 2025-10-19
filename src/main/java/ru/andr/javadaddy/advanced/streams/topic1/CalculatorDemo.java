package ru.andr.javadaddy.advanced.streams.topic1;

public class CalculatorDemo {
    public static void main(String[] args) {

        Calculator calculator = (a, b) -> a + b;

        System.out.println(calculator.operate(1, 4));
    }
}
