package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution167 {

    public static void main(String[] args) {
        Solution167 solution = new Solution167();
        int[] nums = {2, 7, 11, 15};
        int target = 18;
        log.info("{}",solution.twoSum(nums, target));
    }

    public int[] twoSum(int[] numbers, int target) {

        int i = 0;
        int j = numbers.length -1;

        while(i<j){
            if(numbers[i] + numbers[j] == target){
                return new int[]{i+1,j+1};
            }else{
                if(numbers[i] + numbers[j] < target){
                    i++;
                }else{
                    j--;
                }

            }
        }
        return null;
    }
}
