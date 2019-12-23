package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution203 {

    public static void main(String[] args) {
        Solution203 solution = new Solution203();

        ListNode head1 = new ListNode(1);
        ListNode head2 = new ListNode(2);
        ListNode head6 = new ListNode(6);
        ListNode head3 = new ListNode(3);
        ListNode head4 = new ListNode(4);
        ListNode head5 = new ListNode(5);
        ListNode head7 = new ListNode(6);

        head1.next = head2;
        head2.next = head3;
        head3.next = head4;
        head4.next = head5;
        head5.next = head6;
        head6.next = head7;
        log.info("{}",solution.removeElements(head1, 6));

    }

    public ListNode removeElements(ListNode head, int val) {
        if(head == null){
            return null;
        }
        ListNode listNode = head;
        while(listNode.next != null){
            ListNode curNode = listNode.next;
            if(curNode.val == val){
                listNode.next = listNode.next.next;
            }
        }
        if(head.val == val){
            head = head.next;
        }
        return head;
    }

}
