package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1176 {

    public static void main(String[] args) {
        Solution1176 solution = new Solution1176();
//        int [] calories = {1,2,3,4,5};
//        int k = 1;
//        int lower = 3;
//        int upper = 3;

        int [] calories = {6,13,8,7,10,1,12,11};
        int k = 6;
        int lower = 5;
        int upper =37;
        log.info("{}", solution.dietPlanPerformance(calories,k,lower,upper));
    }

    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int target = 0;
        int sum = 0;
        for(int i = 0;i<calories.length;i++){

            if(i > k - 1){
                if(sum < lower){
                    target += -1;
                }else if(sum > upper){
                    target += 1;
                }
                sum -=calories[i-k];
            }
            sum +=calories[i];
        }
        if(calories.length-1>=k-1){
            if(sum < lower){
                target--;
            }
            if(sum > upper){
                target++;
            }
        }

        return target;
    }
}

