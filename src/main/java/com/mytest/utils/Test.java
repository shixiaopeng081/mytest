package com.mytest.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by shixi  on 2019/3/7
 */
@Slf4j
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


        Map<Long, Long> map = new HashMap<>();
        map.put(345678904567890L,345678904567890L);

        Long data = 345678904567890L;

        System.out.println(map.containsKey(data));

        List<String> strList = new ArrayList();

        strList.add("qwfdsa");
        strList.add("11111");
        System.out.println(strList.contains("qwfdsa"));
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("1111","11111");
        concurrentHashMap.put("222","2222");
        concurrentHashMap.put("333","3333");

        concurrentHashMap.remove("222");

        log.info("{}", concurrentHashMap);

    }
}
