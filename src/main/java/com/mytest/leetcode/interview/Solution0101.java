package com.mytest.leetcode.interview;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by shixi  on 2020/4/21
 */
public class Solution0101 {

    public boolean isUnique(String astr) {
        if(astr == null || astr.length() == 0){
            return true;
        }

        String[] split = astr.split("");

        Set sets = new HashSet<>(Arrays.asList(split));

        if(sets.size() == split.length){
            return true;
        }
        return false;

    }


    public static void main(String[] args) {
        Solution0101 solution0101 = new Solution0101();
        solution0101.isUnique("abc");
    }
}
