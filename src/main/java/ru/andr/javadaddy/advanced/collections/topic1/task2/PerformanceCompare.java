package ru.andr.javadaddy.advanced.collections.topic1.task2;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceCompare {
    public static void main(String[] args) {
        ArrayList<Integer> listArray = new ArrayList<>();
        LinkedList<Integer> listLinked = new LinkedList<>();
        long start, end, res;

        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            listArray.add(i);
        }
        end = System.nanoTime();
        res = end - start;
        System.out.println("ArrayList at end time = " + res);

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listArray.add(0, i);
        }
        end = System.nanoTime();
        res = end - start;
        System.out.println("ArrayList at start time = " + res);

        start = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            listLinked.add(i);
        }
        end = System.nanoTime();
        res = end - start;
        System.out.println("LinkedList at end time = " + res);

        start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            listLinked.addFirst(i);
        }
        end = System.nanoTime();
        res = end - start;
        System.out.println("LinkedList at start time = " + res);
    }
}
