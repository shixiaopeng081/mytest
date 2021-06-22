package com.mytest.leetcode.test;

public class EvenList {

    public static void main(String[] args) {
        EvenList evenList = new EvenList();
        //2->1->3->5->6->4->7->NUL

        ListNode node7 = new ListNode(7);
        ListNode node4 = new ListNode(4, node7);
        ListNode node6 = new ListNode(6, node4);
        ListNode node5 = new ListNode(5, node6);
        ListNode node3 = new ListNode(3, node5);
        ListNode node1 = new ListNode(1, node3);
        ListNode node2 = new ListNode(2, node1);

        evenList.oddEvenList(node2);
    }

    public ListNode oddEvenList(ListNode head) {

        int i = 1;
        ListNode node = new ListNode(head.val);
        while(true){
            if(head==null){
                break;
            }
            ListNode listNode = head.next;
            if(i%2 == 1){
                node.next = listNode;
            }

            i++;
            head = head.next;
        }

        return null;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
