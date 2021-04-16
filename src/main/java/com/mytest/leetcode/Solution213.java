package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution213 {

    public static void main(String[] args) {
        Solution213 solution = new Solution213();
        int [] nums = {2,4,7,3,5,9};
        log.info("{}",solution.rob(nums));
    }


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
       if(nums.length == 2){
           return Math.max(nums[0], nums[1]);
       }
        return  Math.max(robRange(nums, 0, nums.length -2), robRange(nums, 1, nums.length -1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start], second = Math.max(nums[start], nums[start+1]);
        for (int i = start + 2; i <= end; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }
}

