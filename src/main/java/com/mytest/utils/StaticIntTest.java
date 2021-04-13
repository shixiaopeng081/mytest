package com.mytest.utils;

/**
 * Created by shixi  on 2021/4/8
 */
public class StaticIntTest {

    static int a = 2;

    public static int aaa(){
        try{

            a = a +2;
            return a;
        }catch(Exception e){

        }finally {
            a = a+2;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(aaa());
//        System.out.println(a);
    }
}
