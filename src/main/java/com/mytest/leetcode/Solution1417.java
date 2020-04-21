package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1417 {

    public static void main(String[] args) {
        Solution1417 solution = new Solution1417();

        String reformat = solution.reformat("covid2019");

        log.info("reformat:{}",reformat);
    }

    public String reformat(String s) {
//        String num = Pattern.compile("[\\D]").matcher(s).replaceAll("").trim();
//        String str = Pattern.compile("[\\d]").matcher(s).replaceAll("").trim();
        String num = s.replaceAll("[\\D]","");
        String str = s.replaceAll("[\\d]","");
        if(Math.abs(num.length()-str.length()) >  1){
            return "";
        }
        String strNew = "";

        String[] splitNum = num.split("");
        String[] splitStr = str.split("");
        int i ,j ;
        for(j=0, i=0; i<num.length() || j< str.length(); ){
            if(num.length() > str.length()){
                strNew = strNew+splitNum[i];
                if(j == str.length()){
                    break;
                }
                strNew = strNew+splitStr[j];
            }else{
                strNew = strNew+splitStr[j];
                if(i ==num.length()){
                    break;
                }
                strNew = strNew+splitNum[i];
            }
            i++;
            j++;
        }

        return strNew;
    }
}

