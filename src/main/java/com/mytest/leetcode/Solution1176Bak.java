package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1176Bak {

    public static void main(String[] args) {
        Solution1176Bak solution = new Solution1176Bak();
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
        int sum = 0;

        int i = 0;
        while(true){
            if((i-1+k)>=calories.length){
                break;
            }
            int curSum = 0;
            for(int j = k;j > 0; j--){
                curSum += calories[i++];
            }

            if(curSum < lower){
                sum += -1;
            }else if(curSum > upper){
                sum += 1;
            }
        }


        return sum;
    }
}

