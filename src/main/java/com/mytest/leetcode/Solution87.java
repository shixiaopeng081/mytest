package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution87 {

    public static void main(String[] args) {
        Solution87 solution = new Solution87();
        String s1 = "";
        String s2 = "";
        solution.isScramble(s1,s2);
        log.info("{}", solution.isScramble(s1,s2));

    }

    public boolean isScramble(String s1, String s2) {
        int strLength = s1.length();
        int result = 1 + (int)(Math.random()*strLength);

        return false;
    }
}

