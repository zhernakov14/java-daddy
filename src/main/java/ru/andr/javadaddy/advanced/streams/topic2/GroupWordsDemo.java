package ru.andr.javadaddy.advanced.streams.topic2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupWordsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("apple", "ant", "banana", "berry", "cherry", "carrot"));

        Map<Character, List<String>> map = list.stream()
                .collect(Collectors.groupingBy(s -> s.charAt(0)));
        System.out.println(map);
    }
}
