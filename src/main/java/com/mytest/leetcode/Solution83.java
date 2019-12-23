package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution83 {

    public static void main(String[] args) {
        Solution83 solution = new Solution83();

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(1);
//        ListNode listNode4 = new ListNode(3);
//        ListNode listNode5 = new ListNode(3);

        listNode.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

//        log.info("{}",solution.isPalindrome1(listNode));
//        ListNode node = solution.deleteDuplicates(listNode);
//        log.info("node = {}", node);
        ListNode node1 = solution.dele(listNode);
        log.info("node1 = {}", node1);

    }

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        boolean flag = false;
        ListNode listNode = head;
        while(listNode.next != null){

            if(listNode.val == listNode.next.val){
                listNode.next = listNode.next.next;
                flag = true;
            }
            listNode = listNode.next;
            if(listNode == null){
                break;
            }
        }
        if(flag){
            deleteDuplicates(head);
        }
        return head;
    }
    public ListNode dele(ListNode head){
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }
}

