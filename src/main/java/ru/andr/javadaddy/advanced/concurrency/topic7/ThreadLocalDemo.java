package ru.andr.javadaddy.advanced.concurrency.topic7;

public class ThreadLocalDemo {
    public static void main(String[] args) throws InterruptedException {

        ThreadLocal<Integer> threadLocalValue = ThreadLocal.withInitial(() -> 0);

        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    threadLocalValue.set(threadLocalValue.get() + 1);
                }
                System.out.println("Поток " + Thread.currentThread().getName() + ", счетчик = "  + threadLocalValue.get());
            });
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }
    }
}
