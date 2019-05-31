package com.mytest.utils;

/**
 * Created by shixi  on 2019/3/7
 */
public class Test {
//    static int x;
//
//    static boolean result =  (x+1>x);

    public static void main(String[] args) {
//        System.out.println(result);
//
//        System.out.println(x+1>x);
//
//        int y = 0;
//        System.out.println(y+1>y);

        int x = 3;//0011
        int y = 2;//0010
        System.out.println(x|y);
        System.out.println(x&y);
        System.out.println(x^y);

        int b = 13;//0000 1101
        System.out.println(b>>2);//11
        System.out.println(b>>>2);//0000 0011
    }
}
