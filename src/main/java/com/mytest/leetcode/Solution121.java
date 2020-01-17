package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2020/1/17
 */
@Slf4j
public class Solution121 {

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();

        int result = solution121.maxProfit(new int[]{1,2});

        log.info("{}",result);
    }


    public int maxProfit(int[] prices) {
        int size = prices.length;
        int max = 0;
        int result = 0;
        for(int i = size -1;i>=0;i--){
            if(i == size -1){
                max = prices[i];
            }
            if(prices[i] > max){
                max = prices[i];
            }else{
                if(result < max - prices[i]){
                    result = max - prices[i];
                }
            }
        }
        return result;
    }
}
