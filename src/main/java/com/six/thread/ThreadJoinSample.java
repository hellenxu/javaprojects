package main.java.com.six.thread;

/**
 * This example use Thread.join() to implement thread running in order.
 * Created by hellenxu on 2017-02-15.
 */
public class ThreadJoinSample {

    public static void main (String[] args){
        final Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println("t1");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t1.join();
                    Thread.sleep(1500);
                    System.out.println("t2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        final Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    t2.join();
                    Thread.sleep(2500);
                    System.out.println("t3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();
        t2.start();
        t3.start();
    }
}
