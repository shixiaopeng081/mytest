package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution27 {

    public static void main(String[] args) {
        Solution27 solution = new Solution27();
        int[] nums = {0,0,1,3,3,4,6,7,8,8,9};
        log.info("{}", solution.removeElement(nums, 8));
        log.info("{}", nums);
    }

    public int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0;i < nums.length; i++){
            if (nums[i] != val) {

                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}

