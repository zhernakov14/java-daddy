package ru.andr.javadaddy.advanced.collections.topic1.task1;

import java.util.ArrayList;
import java.util.List;

public class MergeLists {
    public static void main(String[] args) {
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();

        first.add("first");
        second.add("second");

        List<String> third = new ArrayList<>();
        third.addAll(first);
        third.addAll(second);

        System.out.println(third);
    }
}
