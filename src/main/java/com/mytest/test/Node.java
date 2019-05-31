package com.mytest.test;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by shixi  on 2019/5/13
 */
@Data
@AllArgsConstructor
public class Node<T> {

    private T t;
    private Node next;
}

class  Test{
    public static void main(String[] args) {
        Node node5 = new Node(5,null);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);


        Node head = node1;
        Node curNode = node1.getNext();
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
