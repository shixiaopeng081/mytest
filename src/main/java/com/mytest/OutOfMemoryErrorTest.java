package com.mytest;

/**
 * Created by shixi  on 2019/3/4
 */
public class OutOfMemoryErrorTest {

    public static void main(String[] args) {
        String name = "hello";
        for (int i = 0; i < 10000000; i++) {
            name += name;
        }
        System.out.println(name);
    }
}
