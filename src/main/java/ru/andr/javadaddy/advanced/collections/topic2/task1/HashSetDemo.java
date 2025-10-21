package ru.andr.javadaddy.advanced.collections.topic2.task1;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Orange");
        set.add("Banana");
        set.add("Apple");

        set.forEach(System.out::println);
    }
}
