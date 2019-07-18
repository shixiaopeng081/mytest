package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution14 {

    public static void main(String[] args) {
        Solution14 solution = new Solution14();
        String str[]={"cc","cc"};
        log.info("{}",solution.longestCommonPrefix(str));
    }

    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String str = strs[0];
        if(str.length() > 0){
            boolean flag = true;
            int j = 1;
            String chars = "";
            while(flag && j <= str.length()){
                chars = str.substring(0, j++);
                for(int i = 1;i < strs.length; i++){

                    if(!strs[i].startsWith(chars)){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag && j >= 2){
                return str.substring(0, j-1);
            }
            if(!flag && j > 2){
                return str.substring(0, j-2);
            }
        }
       return "";
    }
}
