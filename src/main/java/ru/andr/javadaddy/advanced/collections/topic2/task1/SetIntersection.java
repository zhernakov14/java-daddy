package ru.andr.javadaddy.advanced.collections.topic2.task1;

import java.util.HashSet;

public class SetIntersection {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        set1.add("Andrey");
        set1.add("Max");
        set1.add("Katy");
        set1.add("Barry");


        set2.add("Alex");
        set2.add("Max");
        set2.add("Piter");
        set2.add("Barry");

        set1.retainAll(set2);
        System.out.println(set1);
    }
}
