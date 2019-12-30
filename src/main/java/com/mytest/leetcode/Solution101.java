package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution101 {

    public static void main(String[] args) {
        Solution101 solution = new Solution101();
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

        boolean result = solution.isSymmetric(root);
        log.info("{}", result);

    }

    public boolean isSymmetric(TreeNode root) {
        List<TreeNode> treeNodeList = new ArrayList<>();
        if(root == null){
            return true;
        }
        treeNodeList.add(root.left);
        treeNodeList.add(root.right);
        Boolean[] result = {true};
        digui(treeNodeList, result);
        return result[0];
    }

    public void digui(List<TreeNode> treeNodeList, Boolean[] result){
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
        int i = 0;
        int j = integerList.size() -1;
        while(i < j){
            if((Integer)integerList.get(i) != (Integer) integerList.get(j)){
                result[0] = false;
                break;
            }
            i++;
            j--;
        }
        if(result[0]){
            digui(nextList, result);
        }
    }
}

