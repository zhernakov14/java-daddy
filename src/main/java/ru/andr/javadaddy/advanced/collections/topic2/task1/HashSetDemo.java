package ru.andr.javadaddy.advanced.collections.topic2.task1;

import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("Apple");
        set.add("Orange");
        set.add("Banana");
        set.add("Apple");

        set.forEach(System.out::println);
    }
}
