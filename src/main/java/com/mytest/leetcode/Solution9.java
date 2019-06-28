package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution9 {

    public static void main(String[] args) {
        Solution9 solution = new Solution9();
        log.info("{}",solution.isPalindrome(121));
    }

    public boolean isPalindrome(int x) {

        char[] chars = String.valueOf(x).toCharArray();

        int i = 0;
        int j = chars.length -1;
        while(i<j){
            if(chars[j] != chars[i]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
