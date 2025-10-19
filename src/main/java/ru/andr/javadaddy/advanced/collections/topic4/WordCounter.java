package ru.andr.javadaddy.advanced.collections.topic4;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    public static void main(String[] args) {
        String[] strs = new String[]{"dog", "cat", "dog", "bird", "cat", "dog"};

        Map<String, Integer> map = new HashMap<>();

        for (String str : strs) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        System.out.println(map);
    }
}
