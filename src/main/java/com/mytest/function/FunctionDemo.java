package com.mytest.function;

import java.util.function.Function;
/**
 * Created by shixi  on 2021/3/15
 */


public class FunctionDemo {

    public static void main(String[] args) {
        String result = testFunction("maoliang ",name -> name + "shaugnshuang");
        System.out.println(result); // maoliang shaugnshuang
    }

    /**
     * 函数型接口，有输入，有输出
     *
     * @param name
     * @param function
     * @return
     */
    public static String testFunction(String name, Function<String, String> function) {
        return function.apply(name);
    }
}
