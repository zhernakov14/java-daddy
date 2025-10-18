package ru.andr.javadaddy.advanced.collections.topic1.task1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(44);
        list.add(-11);
        list.add(999);

        Collections.sort(list);
        System.out.println(list);
    }
}
