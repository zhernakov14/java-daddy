package ru.andr.javadaddy.advanced.streams.topic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountEvenNumbersDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10, 15, 20, 25, 30, 35));

        System.out.println(list.stream().filter(i -> i % 2 == 0).count());
    }
}
