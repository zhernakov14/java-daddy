package ru.andr.javadaddy.advanced.collections.topic3.task2;

import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {
    public static void main(String[] args) {
        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(11);
        deque.addLast(22);

        deque.pollFirst();
        deque.pollLast();

        System.out.println(deque);
    }
}
