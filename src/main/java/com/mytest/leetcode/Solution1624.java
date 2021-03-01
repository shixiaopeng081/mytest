package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1624 {

    public static void main(String[] args) {
        Solution1624 solution = new Solution1624();

//        log.info("{}",solution.maxLengthBetweenEqualCharacters("aa"));
//        log.info("{}",solution.maxLengthBetweenEqualCharacters("abca"));
//        log.info("{}",solution.maxLengthBetweenEqualCharacters("cbzxy"));
//        log.info("{}",solution.maxLengthBetweenEqualCharacters("cabbac"));
        log.info("{}",solution.maxLengthBetweenEqualCharacters("mgntdygtxrvxjnwksqhxuxtrv"));
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        char [] charArray = s.toCharArray();
        int length = charArray.length -1;
        int result = -1;

       for(int i= 0;i< length;i++){
            log.info("{}",i);

            int compare = -1;
            for(int max = length; max> i;max--){
                if(charArray[i] == charArray[max]){
                    compare = max -i -1;
                    break;
//                    log.info("************************{}",s.substring(i+1,max));
                }
            }
           if(compare > result){
               result = compare;
           }
//            log.info("one for {}", result);
        }
        return result;
    }

    public int maxLengthBetweenEqualCharacters1(String s) {
        int ans = -1;
        int[] ch = new int[26];
        for (int i = 0; i < 26; i++) {
            log.info("{}", s.lastIndexOf(i + 'a') - s.indexOf(i + 'a') - 1);
            ans = Math.max(ans, s.lastIndexOf(i + 'a') - s.indexOf(i + 'a') - 1);
        }
        return ans;
    }
}

