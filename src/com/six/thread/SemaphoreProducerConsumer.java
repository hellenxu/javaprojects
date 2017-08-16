package com.six.thread;

import java.util.concurrent.Semaphore;

/**
 * This example uses Semaphore to implement Producer and Consumer
 * Created by hellenxu on 2017-02-15.
 */
public class SemaphoreProducerConsumer {
    public static void main(String[] args) {
        try {
            SemaphoreFactory factory = new SemaphoreFactory();
            new Thread(new Worker(factory)).start();
            new Thread(new Consumer(factory)).start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Worker implements Runnable {
    private SemaphoreFactory factory;

    Worker(SemaphoreFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                factory.produce();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Consumer implements Runnable {
    private SemaphoreFactory factory;

    Consumer(SemaphoreFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 20; i++) {
                factory.consume();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SemaphoreFactory {
    private Semaphore worker, consumer;
    private int inventory = 0;

    SemaphoreFactory() throws InterruptedException {
        worker = new Semaphore(1);
        consumer = new Semaphore(0);
    }

    public void produce() throws InterruptedException {
        worker.acquire();
        System.out.println("producing: " + (++ inventory));
        consumer.release();
    }

    public void consume() throws InterruptedException {
        consumer.acquire();
        System.out.println("consuming: " + inventory --);
        worker.release();
    }
}
