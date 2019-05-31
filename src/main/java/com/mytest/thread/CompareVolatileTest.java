package com.mytest.thread;

/**
 * Created by shixi  on 2018/8/10
 */
public class CompareVolatileTest {

    public volatile int inc = 0;

    public int inc1 = 0;


    public static void main(String[] args) {
        final CompareVolatileTest test = new CompareVolatileTest();
        for (int i = 0; i < 1000; i++) {
             new Thread(){
                @Override
                public void run() {
                    for (int j = 0; j < 10; j++) {
                        test.inc++;
                        test.inc1++;
                    }
                    System.out.println("test.inc=================="+test.inc+"==============test.inc1================="+test.inc1);
                }
            }.start();

        }
//        Thread.yield();//yield()方法执行之后，没有立即启用
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(test.inc);
        System.out.println(test.inc1);
    }
}