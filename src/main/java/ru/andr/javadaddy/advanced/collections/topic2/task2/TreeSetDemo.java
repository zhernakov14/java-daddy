package ru.andr.javadaddy.advanced.collections.topic2.task2;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();

        set.add(100);
        set.add(1);
        set.add(20);
        set.add(90);
        set.add(17);

        System.out.println(set);
    }
}
