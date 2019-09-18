package com.six.thread;

import java.util.concurrent.TimeUnit;
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
//        new Thread(new WaitRunnable()).start();
//        Thread.sleep(1);
//        new Thread(new NotifyRunnable()).start();

        ReentrantLock lock = new ReentrantLock();
        Thread thread1 = new TryLock(lock);
        thread1.setName("thread1");
        thread1.start();
        Thread thread2 = new TryLock(lock);
        thread2.setName("thread2");
        thread2.start();
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

    static class TryLock extends Thread {
        private ReentrantLock reentrantLock;

        public TryLock(ReentrantLock lock) {
            this.reentrantLock = lock;
        }

        @Override
        public void run() {
            try {
                System.out.println("xxl-try-lock: " + Thread.currentThread().getName());
                boolean tryLock = reentrantLock.tryLock(3, TimeUnit.SECONDS);
                if (tryLock) {
                    System.out.println("xxl-success: " + Thread.currentThread().getName());
                    System.out.println("xxl-sleep: " + Thread.currentThread().getName());
                    Thread.sleep(5000);
                    System.out.println("xxl-woke-up: " + Thread.currentThread().getName());
                } else {
                    System.out.println("xxl-try-lock-timeout: " + Thread.currentThread().getName());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("xxl-exception: " + e);
            } finally {
                System.out.println("xxl-unlock: " + Thread.currentThread().getName());
                reentrantLock.unlock();
            }
        }
    }
}
