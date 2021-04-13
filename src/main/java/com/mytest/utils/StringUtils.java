package com.mytest.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/9/17
 */
@Slf4j
public class StringUtils {

    public static void main(String[] args) {
        String str = "https://h5.gdt.qq.com/xjviewer/nemo/1018602?_wv=1";

        log.info("{}", str.lastIndexOf("/"));
        log.info("{}", str.indexOf("?"));

        log.info("{}", str.substring(str.lastIndexOf("/")+1, str.indexOf("?")));

        String test1 = "abc";
        String test2 = "ab" + "c";

        log.info("{}", test1 == test2);
        log.info("{}", test1.equals(test2));

        log.info("内存地址:{}", System.identityHashCode(test1));
        log.info("内存地址:{}", System.identityHashCode(test2));

        String test3 = new String("abc");
        String test4 = new String("abc");
        log.info("{}", test3 == test4);
        log.info("{}", test3.equals(test4));
        log.info("内存地址:{}", System.identityHashCode(test3));
        log.info("内存地址:{}", System.identityHashCode(test4));


        int [] a = new int[3];
        for(int i= 0;i< 5;i++){
            double random = Math.random();

            log.info("{}",a);
        }



    }
}
