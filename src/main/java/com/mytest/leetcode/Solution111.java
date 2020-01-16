package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution111 {

    public static void main(String[] args) {
        Solution111 solution = new Solution111();

//        TreeNode root = new TreeNode(3);
//
//        TreeNode left = new TreeNode(9);
//        TreeNode right = new TreeNode(20);
//        TreeNode node_15 = new TreeNode(15);
//        TreeNode node_17 = new TreeNode(17);
//
//        root.left = left;
//        root.right = right;
//
//
//
//        right.left = node_15;
//        right.right = node_17;

        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        root.left = left;

        int result = solution.minDepth(root);
        log.info("{}", result);

    }
    public int minDepth(TreeNode root) {
        return depth(root);
    }


    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if ((root.left == null) && (root.right == null)) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        if(root.left != null){
            min = Math.min(depth(root.left),min);
        }
        if(root.right != null){
            min = Math.min(depth(root.right),min);
        }
        return  min+1;
    }
}

