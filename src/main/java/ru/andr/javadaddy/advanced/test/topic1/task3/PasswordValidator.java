package ru.andr.javadaddy.advanced.test.topic1.task3;

public class PasswordValidator {
    public static boolean isValid(String password) {
        if (password == null) {
            throw new IllegalArgumentException("password is null");
        }
        return password.length() >= 8 && password.matches("^(?=.*\\d)[a-zA-Z0-9]+$");
    }
}
