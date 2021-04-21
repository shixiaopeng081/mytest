package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
@Slf4j
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        String s = "abcabcbb";
        log.info("{}", solution.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
// 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
    public int lengthOfLongestSubstring1(String s) {

        if (s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public int myself(String s){
        if(s == null && s.length() == 0){
            return 0;
        }
        int leftNum = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap();
        for(int i=0;i< s.length();i++){
            if(map.containsKey(s.charAt(i))){
                leftNum = map.get(s.charAt(i)) + 1;
            }
            map.put(s.charAt(i),i);
            max = Math.max(max, i-leftNum + 1);
        }
        return max;
    }
}
