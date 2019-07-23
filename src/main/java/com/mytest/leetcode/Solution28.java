package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution28 {

    public static void main(String[] args) {
        Solution28 solution = new Solution28();
        log.info("{}", solution.strStr("hello", "ll"));
    }

    public int strStr(String haystack, String needle) {

        if(needle == null){
            return 0;
        }
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
}

