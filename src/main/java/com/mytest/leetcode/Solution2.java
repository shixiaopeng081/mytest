package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

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
public class Solution2 {

    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        ListNode l2 = new ListNode(1);
//        ListNode l4 = new ListNode(4);
//        l2.next = l4;
//        ListNode l3 = new ListNode(3);
//        l4.next = l3;

        ListNode ll5 = new ListNode(1);
        l2.next = ll5;
        ListNode ll9 = new ListNode(1);
        ll5.next = ll9;
        ListNode ll99 = new ListNode(1);
        ll9.next = ll99;
        ListNode ll999 = new ListNode(1);
        ll99.next = ll999;
        ListNode ll9999 = new ListNode(1);
        ll999.next = ll9999;
        ListNode ll99999 = new ListNode(1);
        ll9999.next = ll99999;
        ListNode ll999999 = new ListNode(1);
        ll99999.next = ll999999;
        ListNode ll9999999 = new ListNode(1);
        ll999999.next = ll9999999;
        ListNode ll99999999 = new ListNode(1);
        ll9999999.next = ll99999999;
        ListNode ll999999999 = new ListNode(1);
        ll99999999.next = ll999999999;

//        ListNode ll6 = new ListNode(6);
//        ll5.next = ll6;
//        ListNode ll4 = new ListNode(4);
//        ll6.next = ll4;

        solution.addTwoNumbers2(l2,l2);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        String str1 = "";
        String str2 = "";
        while(true){
            if(l1 == null && l2 ==null){
                break;
            }
            if(l1 != null){
                str1 = str1 + l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                str2 = str2 + l2.val;
                l2 = l2.next;
            }
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        BigDecimal int1 = new BigDecimal(String.valueOf(0));
        BigDecimal int2 = new BigDecimal(String.valueOf(0));
        int i = char1.length;
        int j = char2.length;
        while(i > 0 || j > 0 ){
            if(i > 0){
                int1 = new BigDecimal(String.valueOf(char1[i-1])).multiply(new BigDecimal(String.valueOf(Math.pow(10,i-1)))).add(int1);
                i--;
            }
            if(j >0){
                int2 = new BigDecimal(String.valueOf(char2[j-1])).multiply(new BigDecimal(String.valueOf(Math.pow(10,j-1)))).add(int2);
                j--;
            }

        }
        String result  = int1.add(int2).setScale( 0, BigDecimal.ROUND_DOWN )  + "";
        char [] aa = result.toCharArray();

        ListNode node = new ListNode(Integer.parseInt(String.valueOf(aa[aa.length -1])));
        ListNode next = null;
        for(int k = aa.length-2;k>=0; k--){

            ListNode currentNode = new ListNode(Integer.parseInt(String.valueOf(aa[k])));
            if(k == aa.length-2){
                node.next= currentNode;
                next = currentNode;
            }else{
                next.next = currentNode;
                next = currentNode;
            }


        }
        return node;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode next = null;
        int duoyu = 0;
        while(true){
            if(l1 == null && l2== null){
                break;
            }
            int a = 0;
            if(l1 !=null){
               a = l1.val;
               l1 = l1.next;
            }
            int b = 0;
            if(l2 != null){
                b = l2.val;
                l2= l2.next;
            }
            int sum = a + b + duoyu;
            duoyu = sum/10;
            int result = sum%10;

            ListNode cur = new ListNode(result);
            if(node == null){
                node = cur;
                next = node;
            }else{
                next.next=cur;
                next = cur;
            }
        }
        if(duoyu >0){
            next.next = new ListNode(duoyu);
        }

        return node;
    }
}
