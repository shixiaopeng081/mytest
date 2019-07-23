package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Stack;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution21 {

    public static void main(String[] args) {
        Solution21 solution = new Solution21();
        ListNode node1 = new ListNode(1);
        ListNode node11 = new ListNode(2);
        ListNode node12 = new ListNode(3);
        node1.next = node11;
        node11.next = node12;

        ListNode node2 = new ListNode(1);
        ListNode node21 = new ListNode(3);
        ListNode node22 = new ListNode(4);
        node2.next = node21;
        node21.next = node22;

        ListNode head = solution.mergeTwoLists2(node1, node2);

        while(head != null){
            log.info("{}", head.val);
            head = head.next;
        }
    }


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        } if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;

        return prehead.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2){
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null || l2 != null) {
            if(l1 == null){
                prev.next = l2;
                break;
            }
            if(l2 == null){
                prev.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        return prehead.next;
    }
}

