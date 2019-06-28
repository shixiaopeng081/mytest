package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1 {

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] nums = {3, 2, 3};
        int target = 6;
        log.info("{}",solution.twoSum(nums, target));
        log.info("{}",solution.twoSum1(nums, target));
        log.info("{}",solution.twoSum2(nums, target));
    }

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        outterLoop: for(int i = 0; i < nums.length; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i]+nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break outterLoop;
                }
            }
        }
        return result;
    }

    public int[] twoSum1(int[] nums, int target) {
        int[] result = null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }

        for(int j = 0; j < nums.length; j++){
            int sss = target - nums[j];
            if(map.containsKey(sss) && map.get(sss) != j){
                result = new int[]{j,map.get(sss)};
            }
        }

        return result;
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int j = 0; j < nums.length; j++){
            int sss = target - nums[j];
            if(map.containsKey(sss) && map.get(sss) != j){
                return new int[]{map.get(sss),j};
            }
            map.put(nums[j],j);
        }
        return null;
    }
}
