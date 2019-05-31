package com.mytest.thread;

/**
 * Created by shixi  on 2018/8/10
 */
public class VolatileTest1 {

    public volatile int inc = 0;

    public void increase() {
        inc++;
    }

    public static void main(String[] args) {
        final VolatileTest1 test = new VolatileTest1();
        for (int i = 0; i < 1000; i++) {
            System.out.println("i================================"+i);
            Thread thread = new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        test.increase();
                    }
                    System.out.println("test.inc================================"+test.inc);
                }
            };
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(test.inc);
    }
}