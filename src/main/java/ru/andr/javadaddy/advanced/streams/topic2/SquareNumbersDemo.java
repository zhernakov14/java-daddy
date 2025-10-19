package ru.andr.javadaddy.advanced.streams.topic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SquareNumbersDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        List<Integer> result = list.stream().map(i -> i * i).toList();
        System.out.println(result);
    }
}
