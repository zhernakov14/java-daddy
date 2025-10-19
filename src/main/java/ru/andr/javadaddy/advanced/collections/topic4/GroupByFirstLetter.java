package ru.andr.javadaddy.advanced.collections.topic4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByFirstLetter {
    public static void main(String[] args) {
        String[] strs = new String[]{"Alex", "John", "Max", "Maria", "Andrey"};

        Map<Character, List<String>> map = new HashMap<>();

        for (String str : strs) {
            map.computeIfAbsent(str.charAt(0), c -> new ArrayList<>()).add(str);
        }

        System.out.println(map);
    }
}
