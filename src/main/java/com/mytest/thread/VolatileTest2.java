package com.mytest.thread;

import java.util.concurrent.CountDownLatch;

/**
 * Created by shixi  on 2018/8/10
 */
public class VolatileTest2 {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileTest2 test = new VolatileTest2();
        final CountDownLatch latch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        test.increase();
                    }
                    latch.countDown();
                    System.out.println("test.inc==============================="+test.inc);
                }
            }.start();
        }
        try {
            latch.await();
            System.out.println(test.inc);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}