package ru.andr.javadaddy.advanced.streams.topic1;

import java.util.ArrayList;
import java.util.List;

public class ArrayFilterDemo {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 12, 7, 20, 3};

        MyPredicate<Integer> predicate = i -> i > 10;

        System.out.println(filterArray(array, predicate));
    }

    private static <T> List<T> filterArray(T[] array, MyPredicate<T> predicate) {
        List<T> list = new ArrayList<>();
        for (T element : array) {
            if (predicate.test(element)) {
                list.add(element);
            }
        }
        return list;
    }
}
