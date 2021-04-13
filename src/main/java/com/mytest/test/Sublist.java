package com.mytest.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixi  on 2020/7/8
 */
@Slf4j
public class Sublist {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        list.add("6");
//        list.add("7");
        List<String> stringList = list.subList(0, 1);
        log.info("{}",stringList);

//        List<String> sublist = list.subList(0, 2);
//        log.info("{}",sublist);

    }
}
