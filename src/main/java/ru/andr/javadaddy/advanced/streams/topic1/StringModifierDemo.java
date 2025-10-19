package ru.andr.javadaddy.advanced.streams.topic1;

import java.util.Locale;

public class StringModifierDemo {
    public static void main(String[] args) {

        StringModifier modifier = (s) -> s.toUpperCase(Locale.ROOT) + "!";

        System.out.println(modifier.modify("asd"));
    }
}
