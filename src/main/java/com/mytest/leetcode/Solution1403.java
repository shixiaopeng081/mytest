package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1403 {

    public static void main(String[] args) {
        Solution1403 solution = new Solution1403();
        int[] nums = {4,4,7,6,7};

        log.info(":{}",solution.minSubsequence(nums));
    }

    public List<Integer> minSubsequence(int[] nums) {
        List list = new ArrayList();
        //冒泡排序
        for(int i = 0;i< nums.length ;i++){
            for(int j=0;j< nums.length-i-1;j++){
                if(nums[j+1] > nums[j]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

        int beforSum = 0;
        for(int i = 0;i< nums.length ;i++){

            beforSum = beforSum + nums[i];
            list.add(nums[i]);
            int afterSum = 0;
            for(int j = i+1; j < nums.length;j++){
                afterSum = afterSum + nums[j];
            }
            if(beforSum >  afterSum){
                break;
            }
        }
        return list;
    }
}

