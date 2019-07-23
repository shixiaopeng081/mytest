package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution26 {

    public static void main(String[] args) {
        Solution26 solution = new Solution26();
        int[] nums = {0,0,1,3,3,4,6,7,8,8,9};
        log.info("{}", solution.removeDuplicates(nums));
        log.info("{}", nums);
    }

    public int removeDuplicates(int[] nums) {
        Set set = new HashSet();
        int j = 0;
        for(int i = 0;i < nums.length; i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }

    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

}

