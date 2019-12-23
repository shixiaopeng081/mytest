package com.mytest.test;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/12/20
 */
@Slf4j
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.hammingWeight(00000000000000000000000000001011);
        //二转十
        log.info("{}",Integer.parseInt("00000000000000000000000000001011",2));
        log.info("{}",00000000000000000000000000001011);
//        log.info("{}",solution.hammingWeight(11111111111111111111111111111101));
        log.info("{}",Integer.toBinaryString(11));
    }

    public int hammingWeight(int n) {
        int ten = Integer.parseInt(""+n,2);
        System.out.println(ten);
        String twoStr = Integer.toBinaryString(ten);
        char[] chars = twoStr.toCharArray();
        int num = 0;
        for(int i = 0;i< chars.length; i++){
            if(chars[i]=='1'){
                num++;
            }
        }
        return num;
    }
}
