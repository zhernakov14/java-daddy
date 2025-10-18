package ru.andr.javadaddy.advanced.collections.topic1.task2;

import java.util.LinkedList;
import java.util.List;

public class ListInterfaceDemo {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add(0, "d");
        list.add(1, "dd");
        list.add(2, "ddd");
        System.out.println(list);

        list.set(0, "s");
        list.set(1, "ss");
        list.set(2, "sss");
        System.out.println(list);

        list.remove(1);
        System.out.println(list);
    }
}
