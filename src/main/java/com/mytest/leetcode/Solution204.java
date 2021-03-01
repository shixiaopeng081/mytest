package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution204 {

    public static void main(String[] args) {
        Solution204 solution = new Solution204();


        log.info("{}",solution.countPrimes(10));

    }

    public int countPrimes(int n) {

        int result = 0;
        for (int i = 0; i < n; i++) {
            if(testIsPrime3(i)){
                result++;
            }
        }
        return result;
    }

    public static boolean testIsPrime3(int n){
        if (n <= 3) {
            return n > 1;
        }

        for(int i=2;i*i<=n;i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }

    /********************************上面代码超出时间限制*********************************/

}
