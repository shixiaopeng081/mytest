package com.mytest.thread;

import java.util.concurrent.*;

/**
 * Created by shixi  on 2018/9/4
 */
public class Test1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 20, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));

        executor.allowCoreThreadTimeOut(true);

        for(int i=0;i<15;i++){
            MyTask myTask = new MyTask(i);
            Future future  =  executor.submit(myTask);
            try {
                future.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.println("executor.getTaskCount()========>" + executor.getTaskCount());
            System.out.println("executor.getActiveCount()========>" + executor.getActiveCount());
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }

}
