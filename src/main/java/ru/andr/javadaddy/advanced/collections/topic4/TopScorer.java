package ru.andr.javadaddy.advanced.collections.topic4;

import java.util.HashMap;
import java.util.Map;

public class TopScorer {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Alex", 4);
        map.put("Max", 3);
        map.put("John", 5);
        map.put("Katy", 2);
        map.put("Maria", 5);

        Integer max = null;
        String name = null;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (max == null) max = entry.getValue();
            else {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    name = entry.getKey();
                }
            }
        }
        System.out.println(name);
    }
}
