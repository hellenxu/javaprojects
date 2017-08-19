package com.six.thread;

import java.util.concurrent.Semaphore;

/**
 * Thread sample: Thread t1, t2 and t3 need to run in order.
 * Created by hellenxu on 2017-02-15.
 */
public class ContinuousThreadSample {

    public static void main(String[] args){
        final Semaphore s1 = new Semaphore(1);
        final Semaphore s2 = new Semaphore(1);

        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(2000);
                System.out.println("t1");
                s1.release();
                System.out.println("t1-s1 permits: " + s1.availablePermits());
                System.out.println("t1-s2 permits: " + s2.availablePermits());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2-s1 permits: " + s1.availablePermits());
                System.out.println("t2-s2 permits: " + s2.availablePermits());
                s1.acquire();
                Thread.sleep(1500);
                System.out.println("t2");
                s2.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t3 = new Thread(() -> {
            try {
                System.out.println("t3-s1 permits: " + s1.availablePermits());
                System.out.println("t3-s2 permits: " + s2.availablePermits());
                s2.acquire();
                Thread.sleep(2500);
                System.out.println("t3");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        try {
            s1.acquire();
            System.out.println("main-s1 permits: " + s1.availablePermits());
            System.out.println("main-s2 permits: " + s2.availablePermits());

            s2.acquire();

            System.out.println("main0-s1 permits: " + s1.availablePermits());
            System.out.println("main0-s2 permits: " + s2.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        t2.start();
        t3.start();
    }
}
