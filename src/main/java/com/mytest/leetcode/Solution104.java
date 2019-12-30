package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution104 {

    public static void main(String[] args) {
        Solution104 solution = new Solution104();
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

        int result = solution.maxDepth(root);
        log.info("{}", result);

    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int[] result = {0};
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(root.left);
        treeNodeList.add(root.right);
        digui(treeNodeList, result);
        return result[0];
    }


    public void digui(List<TreeNode> treeNodeList, int[] result){
        List<Integer> integerList = new ArrayList();
        List<TreeNode> nextList = new ArrayList<>();
        for(TreeNode treeNode : treeNodeList){
            if(treeNode!= null){
                integerList.add(treeNode.val);
                nextList.add(treeNode.left);
                nextList.add(treeNode.right);
            }else{
                integerList.add(null);
            }
        }
        if(integerList.size() == 0){
            return ;
        }
        if(nextList.size() >0 ){
            result[0]++;
            digui(nextList, result);
        }
    }
}

