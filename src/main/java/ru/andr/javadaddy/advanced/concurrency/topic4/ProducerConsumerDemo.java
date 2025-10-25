package ru.andr.javadaddy.advanced.concurrency.topic4;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProducerConsumerDemo {
    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                buffer.produce();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                buffer.consume();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }
}

class Buffer {
    private final List<Integer> buffer = new ArrayList<>();
    private final Random random = new Random();

    public synchronized void produce() throws InterruptedException {
        int LIMIT = 5;
        while (true) {
            while (buffer.size() == LIMIT) {
                System.out.println("buffer is full");
                wait();
            }
            int value = random.nextInt(100);
            buffer.add(value);
            System.out.println("produce " + value);
            notifyAll();
            Thread.sleep(500);
        }
    }

    public synchronized void consume() throws InterruptedException {
        while (true) {
            while (buffer.isEmpty()) {
                System.out.println("buffer is empty");
                wait();
            }
            int value = buffer.remove(0);
            System.out.println("consume " + value);
            notifyAll();
            Thread.sleep(500);
        }
    }
}
