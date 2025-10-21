package ru.andr.javadaddy.advanced.collections.topic1.task2;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedList {
    public static void main(String[] args) {
        Queue<String> list = new LinkedList<>();

        list.offer("a");
        System.out.println(list);
        list.offer("b");
        System.out.println(list);
        list.offer("c");
        System.out.println(list);

        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());
    }
}
