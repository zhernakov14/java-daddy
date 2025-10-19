package ru.andr.javadaddy.advanced.streams.topic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueValuesDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 4, 3, 5, 1));

        List<Integer> uniqueElements = list.stream().distinct().toList();
        System.out.println(uniqueElements);
    }
}
