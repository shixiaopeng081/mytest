package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution110 {

    public static void main(String[] args) {
        Solution110 solution = new Solution110();

        TreeNode root = new TreeNode(1);

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);

        root.left = left;
        root.right = right;

//        left.left = three;
        left.right = four;

//        right.left = four;
        right.right = three;

        boolean result = solution.isBalanced(root);
        log.info("{}", result);

    }
    public boolean isBalanced(TreeNode root) {
        return depth(root) != -1;
    }

    public int check(TreeNode treeNode){
        if(treeNode == null){
            return 0;
        }
        int left = check(treeNode.left);
        if(left == -1){
            return -1;
        }
        int right = check(treeNode.right);
        if(right == -1){
            return -1;
        }
        return Math.abs(left - right) < 2?Math.max(left,right) +1:-1;
    }

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        if(left == -1) {
            return -1;
        }
        int right = depth(root.right);
        if(right == -1) {
            return -1;
        }
        return Math.abs(left - right) < 2 ? Math.max(left, right) + 1 : -1;
    }
}

