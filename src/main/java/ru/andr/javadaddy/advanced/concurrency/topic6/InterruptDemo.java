package ru.andr.javadaddy.advanced.concurrency.topic6;

public class InterruptDemo {
    public static void main(String[] args) throws InterruptedException {

        Thread worker = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Работаю...");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        worker.start();

        Thread.sleep(3000);
        worker.interrupt();
    }
}
