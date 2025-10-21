package ru.andr.javadaddy.advanced.collections.topic1.task2;

import java.util.Deque;
import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        Deque<String> list = new LinkedList<>();

        list.add("one");
        list.add("two");
        list.add("three");

        list.addFirst("first");
        list.addLast("last");

        list.forEach(System.out::println);

        list.removeFirst();
        list.removeLast();

        list.forEach(System.out::println);

    }
}
