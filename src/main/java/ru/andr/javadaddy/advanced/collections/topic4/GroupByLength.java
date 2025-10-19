package ru.andr.javadaddy.advanced.collections.topic4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupByLength {
    public static void main(String[] args) {
        String[] strs = new String[]{"hi", "hello", "hey", "hola", "yo", "bonjour"};

        Map<Integer, List<String>> map = new HashMap<>();

        for(String str : strs) {
            map.computeIfAbsent(str.length(), l -> new ArrayList<>()).add(str);
        }

        System.out.println(map);
    }
}
