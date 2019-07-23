package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution35 {

    public static void main(String[] args) {
        Solution35 solution = new Solution35();
        int[] nums = {0,1,3,4,6,7,8,9};
        log.info("{}", solution.searchInsert(nums, 8));
        log.info("{}", nums);
    }

    public int searchInsert(int[] nums, int target) {
        if(nums == null){
            return 0;
        }
        int min = nums[0];
        int max = nums[nums.length - 1];

        if(target < min){
            return 0;
        }
        if(target > max){
            return nums.length;
        }

        for(int i = 0;i < nums.length -1; i++){
            if (nums[i] == target) {
                return i;
            }else if(nums[i] < target && nums[i+1] >= target){
                return i+1;
            }
        }
        return 0;
    }
}

