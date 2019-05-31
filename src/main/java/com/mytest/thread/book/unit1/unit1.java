package com.mytest.thread.book.unit1;

/**
 * Created by shixi  on 2018/12/3
 */
public class unit1 {


    class MyThread extends  Thread{

        @Override
        public void run() {
            System.out.println("Hello from thread");
        }
    }



    public static void main(String[] args) {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Hello from thread");
            }
        };
        Thread thread = new Thread(r);

        System.out.println(thread.isAlive());
        System.out.println(thread.getState());
        System.out.println(thread.getName());
        System.out.println(thread.getPriority());
        System.out.println(Thread.MIN_PRIORITY);
        System.out.println(Thread.MAX_PRIORITY);
        System.out.println(Thread.NORM_PRIORITY);
        System.out.println(thread.isDaemon());


        thread.start();
        System.out.println(thread.isInterrupted());
//        thread.interrupt();

//        thread.setDaemon(true);
//        System.out.println(thread.isDaemon());

    }




}
