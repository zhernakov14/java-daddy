package ru.andr.javadaddy.advanced.collections.topic2.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class SetToListSort {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        set.add(1);
        set.add(-1);
        set.add(5);
        set.add(-99);
        set.add(2);

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        System.out.println(list);
    }
}
