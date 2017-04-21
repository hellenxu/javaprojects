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

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("t1");
                    s1.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s1.acquire();
                    Thread.sleep(1500);
                    System.out.println("t2");
                    s2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    s2.acquire();
                    Thread.sleep(2500);
                    System.out.println("t3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            s1.acquire();
            s2.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.start();
        t2.start();
        t3.start();
    }
}
