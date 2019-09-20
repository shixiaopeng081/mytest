package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution53 {

    public static void main(String[] args) {
        Solution53 solution = new Solution53();
        int [] nums = {-2,1,-3,4,-1,2,1,-5,4};
        log.info("{}", solution.maxSubArray(nums));


        String leartType = "统招,自考";

        String [] type = leartType.split(",");

        log.info("{}", type);
    }

    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}

