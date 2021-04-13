package com.mytest.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixi  on 2021/4/13
 */
@Slf4j
public class SortTest {

    public static void main(String[] args) {
        List<Integer> intList = new ArrayList();

        intList.add(7);
        intList.add(3);
        intList.add(0);
        intList.add(9);
        intList.add(5);
        intList.add(2);

        intList.sort((o1, o2) -> o1.compareTo(o2));

        log.info("{}",intList);

    }
}
