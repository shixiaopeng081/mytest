package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution7 {

    public static void main(String[] args) {
        Solution7 solution = new Solution7();

//        log.info("{}",solution.reverse(789));
        log.info("{}",solution.reverse(-123));

        log.info("{}",solution.reverse1(123));

    }

    public int reverse(int x) {
        if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            return 0;
        }

        String intStr = "";
        boolean flag = false;
        if(x < 0){
            flag = true;
            intStr = String.valueOf(x).substring(1);
        }else{
            intStr = String.valueOf(x);
        }

        char[] chars = intStr.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for(int i= chars.length-1;i>=0;i--){
            stringBuffer.append(chars[i]);
        }
        long y = 0;
        if(flag){
            y = Long.parseLong("-"+stringBuffer.toString());
        }else{
            y = Long.parseLong(stringBuffer.toString());
        }
        if(y > Integer.MAX_VALUE || y < Integer.MIN_VALUE){
            return 0;
        }
        return (int) y;
    }

    public int reverse1(int x) {
        int rev = 0;
        while(x != 0 ){
            int pop = x%10;
            x = x/10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }
            rev = rev*10 + pop;
        }
        return rev;
    }
}
