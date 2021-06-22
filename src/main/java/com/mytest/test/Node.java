package com.mytest.test;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixi  on 2019/5/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node<T> implements Serializable{

    private T t;
    private Node next;
}

class  Test{
    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node head = new Node(1,node2);



        Node curNode = head.getNext();
        head.setNext(null);
        while(curNode != null){
            //System.out.println(head.getT().toString());

            Node next = curNode.getNext();
            curNode.setNext(head);
            head = curNode;
            curNode = next;

        }


        for(int i = 0; i < 5; i++){

            System.out.println(head.getT().toString());
            head = head.getNext();
        }
    }

}

@Slf4j
class Test2{

    public static void main(String[] args) {
        Node node8 = new Node(8,null);
        Node node7 = new Node(7,node8);
        Node node6 = new Node(6,node7);
        Node node5 = new Node(5,node6);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);

        Node head = node1;


        Node current = head.getNext();
        head.setNext(null);
        while(current != null){

            Node node = current.getNext();
            current.setNext(head);
            head = current;
            current = node;

        }

        log.info("{}",head);
        log.info("{}",node1);

        head = reverseKGroup(head, 3);
        log.info("{}", head);

        log.info("{}",reverse(head));

    }

    //k个为一组逆序
    public static Node reverseKGroup(Node head, int k) {
        Node temp = head;
        for (int i = 1; i < k && temp != null; i++) {
            temp = temp.getNext();
        }
        //判断节点的数量是否能够凑成一组
        if(temp == null)
            return head;

        Node t2 = temp.getNext();
        temp.setNext(null);
        //把当前的组进行逆序
        Node newHead = reverseList(head);
        //把之后的节点进行分组逆序
        Node newTemp = reverseKGroup(t2, k);
        // 把两部分连接起来
        head.setNext(newTemp);

        return newHead;
    }

    private static  Node reverseList(Node head){
        Node current = head.getNext();
        head.setNext(null);
        while(current != null){

            Node node = current.getNext();
            current.setNext(head);
            head = current;
            current = node;

        }
        return head;
    }

    //逆序单链表
    private static Node reverse(Node head) {
        if(head == null || head.getNext() == null)
            return head;
        Node result = reverse(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return result;
    }
}
