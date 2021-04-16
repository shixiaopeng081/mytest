package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1780 {

    public static void main(String[] args) {
        Solution1780 solution = new Solution1780();
        log.info("{}",solution.checkPowersOfThree(91));
    }


    public boolean checkPowersOfThree(int n) {
        while(n != 0){
            if(n % 3 > 1){
                return false;
            }
            n = n /3;
        }
        return true;
    }
}

