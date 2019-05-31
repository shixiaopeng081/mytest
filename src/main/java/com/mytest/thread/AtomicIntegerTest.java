package com.mytest.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by shixi  on 2018/8/10
 */
public class AtomicIntegerTest {

    public AtomicInteger inc = new AtomicInteger(0);

    public void increase() {
        inc.incrementAndGet();
    }

    public static void main(String[] args) {
        final AtomicIntegerTest test = new AtomicIntegerTest();
        for (int i = 0; i < 1000; i++) {
             new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        test.increase();
                    }
                    System.out.println("test.inc================================"+test.inc);
                }
            }.start();

        }
//        Thread.yield();//yield()方法执行之后，没有立即启用
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.inc);
    }
}