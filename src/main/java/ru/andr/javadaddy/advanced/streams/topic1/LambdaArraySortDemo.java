package ru.andr.javadaddy.advanced.streams.topic1;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaArraySortDemo {
    public static void main(String[] args) {
        String[] strs = new String[]{"Java", "Lambdaaaa", "Stream", "API"};

        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());

        Arrays.sort(strs, comparator);
        System.out.println(Arrays.toString(strs));
    }
}
