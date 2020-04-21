package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1413 {

    public static void main(String[] args) {
        Solution1413 solution = new Solution1413();
        int[] nums = {-3,2,-3,4,2};
        int i = solution.minStartValue(nums);

        log.info("i:{}",i);
    }

    public int minStartValue(int[] nums) {
        int minValue = 0;
        int sumValue = 0;
        for(int i=0;i< nums.length;i++){
            if(i ==0 ){
                sumValue = sumValue + nums[i];
                minValue = sumValue;
            }else{
                sumValue = sumValue + nums[i];
                if(sumValue < minValue){
                    minValue = sumValue;
                }
            }
        }

        if(minValue >= 0){
            return 1;
        }
        return Math.abs(minValue) +1;
    }
}

