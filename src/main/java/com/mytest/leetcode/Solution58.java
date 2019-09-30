package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution58 {

    public static void main(String[] args) {
        Solution58 solution = new Solution58();
        log.info("{}", solution.lengthOfLastWord("a "));
    }

    public int lengthOfLastWord(String s) {

        if(s.contains(" ")){
            if(s.endsWith(" ")){
                s = s.substring(0,s.length() -1);
                return lengthOfLastWord(s);
            }else{
                int i = s.lastIndexOf(" ");
                return s.substring(i+1).length();
            }
        }else{
            return s.length();
        }

    }
}

