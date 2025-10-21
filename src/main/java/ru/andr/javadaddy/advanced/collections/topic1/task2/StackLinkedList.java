package ru.andr.javadaddy.advanced.collections.topic1.task2;

import java.util.Deque;
import java.util.LinkedList;

public class StackLinkedList {
    public static void main(String[] args) {
        Deque<Integer> list = new LinkedList<>();

        list.push(1);
        System.out.println(list);
        list.push(22);
        System.out.println(list);
        list.push(55);
        System.out.println(list);

        System.out.println(list.pop());
        System.out.println(list.pop());
        System.out.println(list.pop());
    }
}
