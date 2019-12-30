package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution100 {

    public static void main(String[] args) {
        Solution100 solution = new Solution100();
        TreeNode p = new TreeNode(1);
        TreeNode q = new TreeNode(1);

        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        p.left = two;
        p.right = three;

        q.left = two;
        q.right = three;

        boolean result = solution.isSameTree(p,q);
        log.info("{}", result);

    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean flag = false;
        if(p != null && q != null){
            if(p.val == q.val){
                return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
            }

        }else if(p == null && q == null){
            flag = true;
        }
        return flag;
    }
}

