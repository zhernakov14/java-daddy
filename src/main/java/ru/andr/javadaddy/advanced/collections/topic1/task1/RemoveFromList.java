package ru.andr.javadaddy.advanced.collections.topic1.task1;

import java.util.ArrayList;
import java.util.List;

public class RemoveFromList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");

        list.remove(1);
        System.out.println(list);
        list.remove("A");
        System.out.println(list);

    }
}
