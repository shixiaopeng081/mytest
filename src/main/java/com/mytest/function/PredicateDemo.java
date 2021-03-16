package com.mytest.function;

import java.util.function.Predicate;

/**
 * Created by shixi  on 2021/3/15
 */
public class PredicateDemo {

    public static void main(String[] args) {
        Boolean flag = testPredicate("b", str -> str.equals("a"));
        System.out.println(flag); // false
    }

    /**
     * 断言型接口，有输出，输出为Boolean
     *
     * @param str
     * @param predicate
     * @return
     */
    public static Boolean testPredicate(String str, Predicate<String> predicate) {
        return predicate.test(str);
    }
}
