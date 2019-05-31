package com.mytest.utils;

/**
 * Created by shixi  on 2019/4/8
 */
public class A extends B {

    //静态变量
    static int i = 1;
    //静态代码块
    static{
        System.out.println("Class A1: static blocks i = " + i);
    }

    //静态代码块
    static {
        i++;
        System.out.println("Class A2 :static blocks i = " + i);
    }

    //非静态变量
    int j = 1;
    //构造函数
    public A(){
        super();
        i++;
        j++;
        System.out.println("constructor A : i = " + i);
        System.out.println("constructor A : j = " + j);
    }

    //非静态语句块
    {
        i++;
        j++;
        System.out.println("非静态语句块 A : i = " + i);
        System.out.println("非静态语句块 A : j = " + j);
    }
    //非静态方法
    @Override
    public void bDisplay(){
        i++;
        System.out.println("非静态方法 A : i = " + i);
        System.out.println("非静态方法 A : j = " + j);
    }

    //静态方法
    public static void bTest(){
        i++;
        System.out.println("静态方法 A : i = " + i);
    }
}
