package com.mytest.test;

/**
 * Created by shixi  on 2019/5/13
 */
public class NodeTest {

    public static void main(String[] args) {
        class Node {

            String name;
            int index;
            Node next;
            public Node(String name, int index) {
                super();
                this.name = name;
                this.index = index;
            }
        }

        Node a = new Node("a",1);
        Node b = new Node("b",2);
        Node c = new Node("c",3);
        Node d = new Node("d",4);
        Node e = new Node("e",5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        //关键代码开始
        Node pre = null;
        Node head = a;
        Node next = head.next;

        while(next != null){
            head.next = pre;
            pre = head;
            head = next;
            next = next.next;
        }
        head.next = pre;
        //关键代码结束

        //打印验证结果
        while(head != next){
            System.out.println("name==="+head.name);
            head = head.next;

        }
    }
}
