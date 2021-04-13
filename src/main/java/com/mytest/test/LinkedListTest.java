package com.mytest.test;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by shixi  on 2021/3/17
 */
@Slf4j
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList();

        list.add("a");
        list.add("b");
        list.add("c");
        list.add("x");
        list.add("y");
        list.add("z");


        log.info("list.getFirst() = {}",list.getFirst());

        log.info("list.getLast() = {}", list.getLast());
        log.info(list.element());

        String last = list.getLast();

        //查看链表查询的实现方法
        list.get(5);
    }
}
