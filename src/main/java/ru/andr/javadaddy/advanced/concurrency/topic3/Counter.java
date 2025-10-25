package ru.andr.javadaddy.advanced.concurrency.topic3;

public class Counter {
    private int count;

    public synchronized void increment() {
        count++;
    }

    public int getCount() {
        return count;
    }
}
