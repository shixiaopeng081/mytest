package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;


@Slf4j
public class Solution653 {

    public static void main(String[] args) {
        Solution653 solution = new Solution653();

        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);

        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;

        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;

        treeNode6.right = treeNode7;

        // 先遍历，再查找
        log.info("{}", solution.findTarget(treeNode5, 9));
        log.info("{}", solution.findTarget1(treeNode5, 9));


        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;

        //bst查找法
        log.info("{}", solution.preOrder(treeNode5, treeNode5,28));
        log.info("{}", solution.findTarget2(treeNode5, treeNode5,28));

    }

    public boolean findTarget(TreeNode root, int k) {

        recursion(root);
        for(int i = 0;i< integerList.size(); i++){
            int target = k - integerList.get(i);
            if(integerList.contains(target) && target != integerList.get(i)){
                return true;
            }
        }
        return false;

    }

    public boolean findTarget1(TreeNode root, int k) {

        recursion(root);
        int i = 0;
        int j = integerList.size()-1;
        while(i<j){
            if(integerList.get(i) + integerList.get(j) == k){
                return true;
            }else if(integerList.get(i) + integerList.get(j) > k){
                j --;
            }else{
                i++;
            }

        }
        return false;

    }
    public boolean preOrder(TreeNode node,TreeNode root,int k){
        if (node == null) {
            return false;
        }
        int target = k - node.val;
        TreeNode foundNode =  findV(root,target);

        if(foundNode != null && node != foundNode) {
            return true;
        } else{
            return preOrder(node.left,root, k) || preOrder(node.right,root,k);
        }
    }

    private boolean findTarget2(TreeNode treeNode,TreeNode root, int k) {
        if(treeNode == null){
            return false;
        }
        int val = treeNode.val;
        int target = k - val;

        TreeNode node = findNode(root, target);
        if(node != null && node != treeNode){
            return true;
        }else{
            return findTarget2(treeNode.left,root,k) || findTarget2(treeNode.right,root,k);
        }
    }

    List<Integer> integerList = new ArrayList<>();
    private void recursion(TreeNode root) {
        if (root != null) {
            recursion(root.left);

            integerList.add(root.val);

            recursion(root.right);
        }
    }

    private TreeNode findNode(TreeNode treeNode, int val){
        if(treeNode == null){
            return null;
        }
        if(treeNode.val == val){
            return treeNode;
        }else if(treeNode.val < val){
            return findNode(treeNode.right, val);
        }else{
            return findNode(treeNode.left, val);
        }

    }

    public TreeNode findV(TreeNode node,int v){
        if(node == null) {
            return null;
        }
        if(node.val == v) {
            return node;
        }
        if (v > node.val) {
            return findV(node.right,v);
        } else {
            return findV(node.left, v);
        }
    }
    
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
          val = x;
      }
  }
