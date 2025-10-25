package ru.andr.javadaddy.advanced.concurrency.topic2;

public class RunnableLambdaDemo {
    public static void main(String[] args) {
        Runnable runnable1 = () -> System.out.println("Task 1 is running");
        Runnable runnable2 = () -> System.out.println("Task 2 is running");
        Runnable runnable3 = () -> System.out.println("Task 3 is running");

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

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
    }
}
