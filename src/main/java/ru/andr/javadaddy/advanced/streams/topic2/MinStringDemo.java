package ru.andr.javadaddy.advanced.streams.topic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinStringDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("elephant", "cat", "hippopotamus", "dog", "lion"));

        list.stream().min(Comparator.comparing(String::length)).ifPresent(System.out::println);
    }
}
