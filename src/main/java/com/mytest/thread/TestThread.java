package com.mytest.thread;

/**
 * Created by shixi  on 2018/8/10
 */
public class TestThread {

    public static int sum = 0;
    class Add implements Runnable {
        @Override
        public void run() {
            for (int i = 0;i < 10; i++){
                sum += 1;
            }

            System.out.println(sum);
        }
    }
    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            new Thread(new TestThread().new Add()).start();
        }
        try {
            Thread.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("************************"+sum);
    }

}
