package com.mytest.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by shixi  on 2018/9/4
 */
public class Test {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 2, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        for(int i=0;i<30;i++){
            MyTask myTask = new MyTask(i);
            System.out.println("i==========================================="+i);
            executor.execute(myTask);
            System.out.println("executor.getTaskCount()========>" + executor.getTaskCount());
            System.out.println("executor.getActiveCount()========>" + executor.getActiveCount());
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
//        executor.shutdown();
        System.out.println("主线程****************************************************");
        for(int i =0;i<10;i++){
            System.out.println("executor.getTaskCount()========>" + executor.getTaskCount());
            System.out.println("executor.getActiveCount()========>" + executor.getActiveCount());
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        try {
            Thread.sleep(1000);
            for(int i =0;i<10;i++){
                System.out.println("executor.getTaskCount()========>" + executor.getTaskCount());
                System.out.println("executor.getActiveCount()========>" + executor.getActiveCount());
                System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                        executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
            }
            Thread.sleep(400);
            MyTask myTask = new MyTask(99);
            executor.execute(myTask);
            System.out.println("executor.getTaskCount()========>" + executor.getTaskCount());
            System.out.println("executor.getActiveCount()========>" + executor.getActiveCount());
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        MyTask myTask = new MyTask(100);
        executor.execute(myTask);
        System.out.println("executor.getTaskCount()========>" + executor.getTaskCount());
        System.out.println("executor.getActiveCount()========>" + executor.getActiveCount());
        System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
    }
}


class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
