package com.mytest.thread;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Data;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by shixi  on 2018/9/4
 */
public class Test2 {
    public static void main(String[] args) {//throws InterruptedException, BrokenBarrierException {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        System.out.println(LocalDateTime.now());
        LocalDateTime localDateTime = LocalDateTime.parse("2018-07-20T07:25:59.097Z", df);
        String format = df.format(localDateTime);
        System.out.println(format);


        //当前时间Date
        Date now = new Date();
        System.out.println(now);
//Wed Jan 31 23:32:03 GMT+08:00 2018

//例如我的环境时区为：(UTC+08:00)北京，重庆，香港特别行政区，乌鲁木齐（+0800）
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        System.out.println(sdf.getTimeZone());
        System.out.println(sdf.format(now));

        String utcTime = "2018-01-31T14:32:19Z";
        SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
//设置时区UTC
        df1.setTimeZone(TimeZone.getTimeZone("UTC"));
//格式化，转当地时区时间
        Date after = null;
        try {
            after = df1.parse(utcTime);

            System.out.println(after);

            df1.applyPattern("yyyy-MM-dd HH:mm:ss");
//默认时区
            df1.setTimeZone(TimeZone.getDefault());
            System.out.println(df1.format(after));
        } catch (ParseException e) {
            e.printStackTrace();
        }


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        Test2.class.wait();
//        List<Integer> list = new ArrayList<>();
//        List<Integer> newList = new ArrayList<>();
//        for (int i = 0 ; i < 5; i ++) { //初始5个
//            list.add(i);
//        }
//        for (int i = 5 ; i < 20; i ++) {
//            newList.add(i);
//        }
//        list.addAll(newList);  //一次性增加15个
//        list.add(20);


//        Vector<Thread> vectors=new Vector<Thread>();
//        //启用5个线程
//        for(int i=1;i<=5;i++){
//            Thread childrenThread=new Thread(new Runnable(){
//                @Override
//                public void run(){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("子线程执行！");
//
//                }
//            });
//            vectors.add(childrenThread);
//            childrenThread.start();
//        }
//        //主线程
//        for(Thread thread : vectors){
//            thread.join(); //使用join来保证childrenThread的5个线程都执行完后，才执行主线程
//        }
//        System.out.println("主线程执行！");






//        final CyclicBarrier barrier=new CyclicBarrier(6);
//        //启用5个线程
//        for(int i=1;i<=5;i++){
//            new Thread(new Runnable(){
//                @Override
//                public void run(){
//                    try {
//                        Thread.sleep(1000);
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println("子线程准备就绪！");
//
//                    try {
//                        barrier.await();//到达屏障
//                       // System.out.println("子线程执行！");
//                    } catch (InterruptedException | BrokenBarrierException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//
//                }
//            }).start();
//
//        }
//        //主线程
//        System.out.println("主线程准备就绪！");
//      barrier.await();//阻塞当前线程直到latch中数值为零才执行
//        System.out.println("主线程执行！");
    }




}
