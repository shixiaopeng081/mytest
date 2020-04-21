package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2020/1/17
 */
@Slf4j
public class Solution121 {

    public static void main(String[] args) {
        Solution121 solution121 = new Solution121();

        int result = solution121.maxProfit(new int[]{1,2,3,4,5});

        log.info("{}",result);
    }


    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }
}
