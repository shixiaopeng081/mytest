package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1137 {

    public static void main(String[] args) {
        Solution1137 solution = new Solution1137();
        log.info("{}", solution.tribonacci(25));
    }

    public int tribonacci(int n) {

        if(n == 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 1;
        }
        int T1 = 0;
        int T2 = 1;
        int T3 = 1;
        int target = 0;
        for(int i = 3; i <= n; i++){
            target = T1+T2+T3;
            T1 = T2;
            T2 = T3;
            T3 = target;
        }
        return target;
    }
}

