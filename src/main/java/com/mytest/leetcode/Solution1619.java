package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1619 {

    private double asDouble;

    public static void main(String[] args) {
        Solution1619 solution = new Solution1619();

//        log.info("{}",solution.maxLengthBetweenEqualCharacters("aa"));
//        log.info("{}",solution.maxLengthBetweenEqualCharacters("abca"));
//        log.info("{}",solution.maxLengthBetweenEqualCharacters("cbzxy"));
//        log.info("{}",solution.maxLengthBetweenEqualCharacters("cabbac"));
        int [] arr = {1,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,3};
        int [] arrs = {9,7,8,7,7,8,4,4,6,8,8,7,6,8,8,9,2,6,0,0,1,10,8,6,3,3,5,1,10,9,0,7,10,0,10,4,1,10,6,9,3,6,0,0,2,7,0,6,7,2,9,7,7,3,0,1,6,1,10,3};
        log.info("{}",solution.trimMean(arrs));
    }

    public double trimMean(int[] arr) {

        Arrays.sort(arr);
//        log.info("{}", arr);
//        log.info("{}", arr.length);

        List<Integer> collect = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int num = collect.size()*5/100;
        for (int i = 0; i < num; i++) {
            collect.remove(0);
            collect.remove(collect.size() - 1);
        }
//        log.info("{}", collect);
//        log.info("{}", collect.size());
        double asDouble = collect.stream().mapToDouble(value -> value).average().getAsDouble();
        java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#.00000");
        return  Double.parseDouble(df.format(asDouble));
//        return Arrays.stream(arr).average().getAsDouble();
    }
}

