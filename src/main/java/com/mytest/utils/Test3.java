package com.mytest.utils;

/**
 * Created by shixi  on 2019/4/2
 */
public class Test3 {

    public static  void main(String[] args) {
        Thread t = new Thread(){
            @Override
            public void run() {
                pong();
            }
        };
        System.out.println("Ping");
        t.run();


    }
    static  void pong(){
        System.out.println("pong");
    }
}
