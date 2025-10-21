package ru.andr.javadaddy.advanced.collections.topic2.task2;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetRanges {
    public static void main(String[] args) {
        SortedSet<Integer> set = new TreeSet<>();

        for (int i = 1; i <= 20; i++) {
            set.add(i);
        }

        System.out.println(set.headSet(10));
        System.out.println(set.tailSet(10));
        System.out.println(set.headSet(15).tailSet(5));
    }
}
