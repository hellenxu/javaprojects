package com.six.thread;

/**
 * Created by Xiaolin on 2017-08-15.
 */
public class Consumer0 implements Runnable {
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ProductFactory.getInstance().consume();
        }
    }
}
