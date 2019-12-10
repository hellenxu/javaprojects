package main.java.com.six.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Xiaolin on 2017-08-15.
 */
public class ProductFactory {

    public static void main(String[] args) {
        startRunnable(WORKER_AMOUNT, Worker0.class);
        startRunnable(CONSUMER_WINDOW, Consumer0.class);
    }

    private static void startRunnable(int threadNum, Class runnable) {
        ExecutorService pool = Executors.newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            try {
                pool.execute((Runnable) runnable.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        pool.shutdown();
    }

    private static final int INVENTORY_SIZE = 16;
    private static final int WORKER_AMOUNT = 10;
    private static final int CONSUMER_WINDOW = 10;

    private static int currentSize = 0;
    private static volatile ProductFactory factory;

    private ProductFactory() {
    }

    static ProductFactory getInstance() {
        if (factory == null) {
            synchronized (ProductFactory.class) {
                if (factory == null) {
                    factory = new ProductFactory();
                }
            }
        }
        return factory;
    }

    synchronized void produce() {
        while (currentSize >= INVENTORY_SIZE) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("producing: " + (++currentSize));
        notify();
    }

    synchronized void consume() {
        while (currentSize <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("consuming: " + currentSize);
        --currentSize;
        notify();
    }
}
