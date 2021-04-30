package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution13 {

    public static void main(String[] args) {
        Solution13 solution = new Solution13();
        log.info("{}",solution.romanToInt("121"));
    }

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.size();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int ans = 0;
        for(int i = 0;i < s.length();) {
            if(i + 1 < s.length() && map.containsKey(s.substring(i, i+2))) {
                ans += map.get(s.substring(i, i+2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i+1));
                i ++;
            }
        }
        return ans;
    }

    public int romanToInt1(String s){
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'I':
                    result += 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
            }
        }
        for(int j = 0; j < s.length() - 1; j++) {
            switch("" + s.charAt(j) + s.charAt(j+1)) {
                case "IV":
                case "IX":
                    result -= 2;
                    break;
                case "XL":
                case "XC":
                    result -= 20;
                    break;
                case "CD":
                case "CM":
                    result -= 200;
                    break;
            }
        }
        return result;
    }
}
