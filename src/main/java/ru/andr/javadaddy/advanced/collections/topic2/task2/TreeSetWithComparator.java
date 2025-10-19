package ru.andr.javadaddy.advanced.collections.topic2.task2;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetWithComparator {
    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(Comparator.reverseOrder());

        set.add("Apple");
        set.add("Orange");
        set.add("Banana");

        System.out.println(set);
    }
}
