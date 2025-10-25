package ru.andr.javadaddy.advanced.concurrency.topic1;

public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread " + getName() + " says: Hello from thread!");
    }
}
