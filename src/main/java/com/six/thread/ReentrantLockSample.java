package com.six.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author hellenxu
 * @date 2019-08-22
 * Copyright 2019 Six. All rights reserved.
 */
public class ReentrantLockSample {
    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new WaitRunnable()).start();
        Thread.sleep(1);
        new Thread(new NotifyRunnable()).start();
    }

    static class WaitRunnable implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("xxl-wait-runnable: " + Thread.currentThread().getName() + System.currentTimeMillis());
                condition.await();
                System.out.println("xxl-wait-runnable: " + Thread.currentThread().getName() + System.currentTimeMillis());
            } catch (InterruptedException e) {
                System.out.println("xxl-wait-exception: " + e.getMessage());
            } finally {
                lock.unlock();
            }
        }
    }

    static class NotifyRunnable implements Runnable {

        @Override
        public void run() {
            lock.lock();
            try {
                System.out.println("xxl-notify-runnable: " + Thread.currentThread().getName() + System.currentTimeMillis());
                condition.signalAll();
            } finally {
                lock.unlock();
            }
        }
    }
}
