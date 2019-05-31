package com.mytest.test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by shixi  on 2019/4/30
 */
public class TestExchanger {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        ExecutorService es = Executors.newFixedThreadPool(2);  //拥有两个线程的线程池
        es.execute(new Runnable() {
            @Override
            public void run() {
                String A = "银行流水A";
                try {
                    String B = exchanger.exchange(A);
                    System.out.println("银行流水A线程，交换后的数据为===="+ B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        es.execute(new Runnable() {
            @Override
            public void run() {
                String B = "银行流水B";
                try {
                    String A = exchanger.exchange(B);
                    System.out.println("A和B数据是否一致： " + A.equals(B) + ",A: " + A + ",B: " + B);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}