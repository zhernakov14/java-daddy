package ru.andr.javadaddy.advanced.collections.topic1.task2;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorRemovalDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        Iterator<Integer> iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next() % 2 == 0) {
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
