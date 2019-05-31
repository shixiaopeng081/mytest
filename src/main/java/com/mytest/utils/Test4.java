package com.mytest.utils;

import jdk.nashorn.internal.ir.annotations.Reference;

/**
 * Created by shixi  on 2019/4/2
 */
@Reference
public class Test4 extends Abstractlt{
    private int value = 0;

    @Override
    public int value() {
        return value;
    }

    public static void main(String[] args) {
        System.out.println(prod(1,4));
    }


    public static int prod(int m, int n){
        if(m ==n ){
            return n;
        }else{
            int recurse = prod(m,n -1);
            int result = n* recurse;
            return  result;
        }
    }
}


abstract class Abstractlt{
    protected abstract int value();
}


