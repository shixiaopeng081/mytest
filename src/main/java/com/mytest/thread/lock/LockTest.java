package com.mytest.thread.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shixi  on 2019/2/15
 */
public class LockTest {

    public void test3() throws Exception{
        final Lock lock=new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                lock.lock();
                System.out.println(Thread.currentThread().getName()+" interrupted.");
            }
        });
        t1.start();
        Thread.sleep(1000);
        System.out.println(" 1111111111111");
        t1.interrupt();
        System.out.println(" 2222222222222");
        Thread.sleep(1000000);
    }

    public void test4() throws Exception{
        final Lock lock=new ReentrantLock();
        lock.lock();
        Thread.sleep(1000);
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" interrupted.");
                }
            }
        });
        t1.start();
        Thread.sleep(1000);
        System.out.println(" 1111111111111");
        t1.interrupt();
        System.out.println(" 2222222222222");
        Thread.sleep(1000000);
    }

    public void test5() throws Exception{
        final Lock lock=new ReentrantLock();
        Thread t1=new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    lock.lockInterruptibly();
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName()+" interrupted.");
                }
            }
        });
        t1.start();
        System.out.println(" 1111111111111");
        t1.interrupt();
        System.out.println(" 2222222222222");
        Thread.sleep(10000000);
    }


    public LockTest() {
    }

    public static void main(String[] args) throws Exception {
        LockTest test = new LockTest();
        //主线程获取到锁，没释放，子线程一直阻塞,忽视interrupt()
//        test.test3();
        //lock.lockInterruptibly();响应了interrupt()；
//        test.test4();
        //验证test4
        test.test5();
    }
}
