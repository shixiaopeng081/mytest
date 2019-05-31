package com.mytest.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shixi  on 2019/4/3
 */
public class ThreadTest {
    static Integer a ;
    public static void main(String[] args) {
        //创建一个临界资源o
        Object o = new Object();
        //创建一个Integer集合，每次掷出来的骰子都存放在这个集合里。
        List<Integer> list = new ArrayList<Integer>();

        //创建A线程
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //对o这个临界资源加锁
                synchronized (o) {
                    //因为不知道要掷多少次骰子，才能达到标准，所以使用while(true)
                    while(true) {
                        //唤醒所有等待的线程，让等待的线程进入就绪状态
                        o.notifyAll();
                        //设置随机数
                        Random rd = new Random();
                        a = rd.nextInt(6)+1;
                        //打印a线程生成的随机数
                        System.out.println("a"+a);
                        //把随机数添加到集合中
                        list.add(a);
                        try {
                            //判断集合中的元素连续3个是否都==6
                            if(list.get(list.size()-1)==6&&list.get(list.size()-2)==6&&list.get(list.size()-3)==6) {
                                //满足则跳出
                                return;
                            }
                            //不满足则等待
                            o.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {

            @Override
            public void run() {
                ////对o这个临界资源加锁
                synchronized(o) {

                    while(true) {
                        //唤醒所有等待的线程，让等待的线程进入就绪状态
                        o.notifyAll();
                        //输出这个a
                        System.out.println(a);
                        try {
                            //判断是否满足条件
                            if(list.get(list.size()-1)==6&&list.get(list.size()-2)==6&&list.get(list.size()-3)==6) {
                                //满足，跳出
                                return;
                            }
                            //等待
                            o.wait();
                        } catch (InterruptedException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        //启动线程
        t1.start();
        t2.start();
    }
}
