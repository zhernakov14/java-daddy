package ru.andr.javadaddy.advanced.concurrency.topic1;

public class ThreadExtendDemo {
    public static void main(String[] args) {

        Thread thread1 = new MyThread();
        Thread thread2 = new MyThread();
        Thread thread3 = new MyThread();

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Threads is finished");
    }
}
