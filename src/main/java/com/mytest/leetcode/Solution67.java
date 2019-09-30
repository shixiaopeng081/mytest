package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution67 {

    public static void main(String[] args) {
        Solution67 solution = new Solution67();
        log.info("{}", solution.addBinary("1111", "1111"));
    }

    public String addBinary(String a, String b) {
        String result = "";
        int isAdd = 0;
        int aLength = a.length() -1 ;
        int bLength = b.length() - 1;
        while(aLength >= 0 || bLength >= 0){
            int temp = isAdd;
            if(aLength < 0){
                temp +=0;
            }else{
                temp += Integer.parseInt(a.charAt(aLength)+"");
            }
            if(bLength < 0){
                temp +=0;
            }else{
                temp += Integer.parseInt(b.charAt(bLength)+"");
            }
            if(temp == 3){
                isAdd = 1;
                result = "1"+result;
            }else if(temp == 2){
                isAdd = 1;
                result = "0"+result;
            }else{
                isAdd = 0;
                result = temp+result;
            }
            aLength--;
            bLength--;
        }
        if(isAdd == 1){
            result = isAdd+result;
        }
        return result;
    }
}

