package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution204 {

    public static void main(String[] args) {
        Solution204 solution = new Solution204();


        log.info("{}",solution.countPrimes(7));

    }

    public int countPrimes3(int n) {

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += testIsPrime3(i) ? 1 : 0;
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

    public int countPrimes(int n) {
        int[] isPrime = new int[n];
        Arrays.fill(isPrime, 1);
        int ans = 0;
        for (int i = 2; i < n; ++i) {
            if (isPrime[i] == 1) {
                ans += 1;
                if ((long) i * i < n) {
                    for (int j = i * i; j < n; j += i) {
//                        log.info("j============{}", j);
                        isPrime[j] = 0;
                    }
                }
            }
        }
        return ans;
    }

}
