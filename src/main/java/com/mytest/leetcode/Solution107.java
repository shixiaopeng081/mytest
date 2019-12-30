package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution107 {

    public static void main(String[] args) {
        Solution107 solution = new Solution107();
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

        List<List<Integer>> result = solution.levelOrderBottom(root);
        log.info("{}", result);

    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return Collections.emptyList();
        }
        List<TreeNode> treeNodeList = new ArrayList<>();
        treeNodeList.add(root.left);
        treeNodeList.add(root.right);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> integerList = new ArrayList();
        integerList.add(root.val);
        result.add(integerList);
        digui(treeNodeList, result);
        Collections.reverse(result);
        return result;
    }

    public void digui(List<TreeNode> treeNodeList, List<List<Integer>> result){
        List<Integer> integerList = new ArrayList();
        List<TreeNode> nextList = new ArrayList<>();
        for(TreeNode treeNode : treeNodeList){
            if(treeNode!= null){
                integerList.add(treeNode.val);
                nextList.add(treeNode.left);
                nextList.add(treeNode.right);
            }
        }
        if(integerList.size() == 0){
            return ;
        }
        result.add(integerList);
        if(nextList.size() > 0){
            digui(nextList, result);
        }
    }
}

