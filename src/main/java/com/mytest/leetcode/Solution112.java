package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution112 {

    public static void main(String[] args) {
        Solution112 solution = new Solution112();

        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(4);
        TreeNode right = new TreeNode(8);

        TreeNode node_11 = new TreeNode(11);
        TreeNode node_7 = new TreeNode(7);
        TreeNode node_2 = new TreeNode(2);


        TreeNode node_13 = new TreeNode(13);
        TreeNode node_4 = new TreeNode(4);
        TreeNode node_1 = new TreeNode(1);

        root.left = left;
        root.right = right;


        left.left = node_11;
        node_11.left = node_7;
        node_11.right = node_2;

        right.left = node_13;
        right.right = node_4;

        node_4.right = node_1;

        boolean result = solution.hasPathSum(root, 22);
        log.info("{}", result);

    }

    public boolean hasPathSum(TreeNode root, int sum) {

        List<Integer> intList = new ArrayList<>();
        depth(root,0, intList);
        if(intList.contains(sum)){
            return true;
        }
        return  false;
    }


    private void depth(TreeNode root, int self,List<Integer> intList) {
        if (root == null) {
            return;
        }
        self = self + root.val;
        if ((root.left == null) && (root.right == null)) {

            intList.add(self);
            return;
        }
        if(root.left != null){
            depth(root.left,self,intList);
        }
        if(root.right != null){
            depth(root.right,self,intList);
        }
    }
}

