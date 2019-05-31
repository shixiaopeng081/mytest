package com.mytest.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shixi  on 2018/8/14
 */
public class SynDemo {

    public static void main(String[] arg){
//        Runnable t1=new MyThread();
//        new Thread(t1,"t1").start();
//        new Thread(t1,"t2").start();

        Runnable t2=new MyThread1();
        new Thread(t2,"t3").start();
        new Thread(t2,"t4").start();
        new Thread(t2,"t5").start();
        new Thread(t2,"t6").start();
        new Thread(t2,"t7").start();

    }

}
class MyThread implements Runnable {

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 1000; i++){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }

    }
}

class MyThread1 implements Runnable {

    private Lock lock=new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try{
            for(int i=0;i<500;i++){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }finally{
            lock.unlock();
        }
    }

}
