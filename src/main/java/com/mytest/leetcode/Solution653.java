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

        //左右
        treeNode5.left = treeNode3;
        treeNode5.right = treeNode6;

        treeNode3.left = treeNode2;
        treeNode3.right = treeNode4;

        treeNode6.right = treeNode7;

        //父
        treeNode2.parent = treeNode3;
        treeNode4.parent = treeNode3;

        treeNode7.parent = treeNode6;

        treeNode3.parent = treeNode5;
        treeNode6.parent = treeNode5;

        /**
         * 中序遍历二叉树
         */
        //参数为根节点
//        solution.inOrder(treeNode5);
//        solution.preOrder(treeNode5);
//        solution.postOrder(treeNode5);

        // 先遍历，再查找
//        log.info("{}", solution.findTarget(treeNode5, 9));
//        log.info("{}", solution.findTarget1(treeNode5, 9));


        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);

        node2.left = node1;
        node2.right = node3;

        //bst查找法
//        log.info("{}", solution.preOrder(treeNode5, treeNode5,28));
//        log.info("{}", solution.findTarget2(treeNode5, treeNode5,28));


        //插入
        TreeNode treeNode1 = new TreeNode(1);
        boolean b = solution.insertNode(treeNode5, treeNode1);
        log.info("insert result {}", b);
        solution.inOrder(treeNode5);

        TreeNode treeNode9 = new TreeNode(9);
        boolean b9 = solution.insertNode(treeNode5, treeNode9);
        log.info("insert result {}", b9);
        solution.inOrder(treeNode5);

        solution.removeNode(treeNode5, 3);
        log.info("删除操作");
        solution.inOrder(treeNode5);
    }

    /**
     * 删除节点，分三种情况
     * 1、叶子节点，直接删除
     * 2、该节点只有左子树或右子树, 子节点直接上移
     * 3、左右都有子树，利用中序找到上一个顺序节点，替换。然后删除上一个节点之前的位置，且替换
     *
     * @param root
     * @param val
     */
    public void removeNode(TreeNode root, int val){
        if(root == null){
            return;
        }

        if(root.val > val){
            removeNode(root.left, val);
        }else if(root.val < val){
            removeNode(root.right, val);
        }else if(root.val == val){
            if(root.left == null && root.right == null){
                //定位在叶子节点
                TreeNode parent = root.parent;
                if(parent.left == root){
                    parent.left = null;
                }
                if(parent.right == root){
                    parent.right = null;
                }
                return;
            }else if(root.left != null && root.right == null){
                //定位在只有左子节点
                TreeNode parent = root.parent;
                parent.left = root.left;
                return;
            }else if(root.left == null && root.right != null){
                //定位在只有右子节点
                TreeNode parent = root.parent;
                parent.right = root.right;
                return;
            }else{
                //左右节点都有
                TreeNode node = root.left;
                while(node.right != null){
                    node = node.right;
                }
                //node就是当前节点的中序前驱节点
                log.info("node 节点 {}", node.val);
                //替换
                root.val = node.val;
                //删除原node节点
                removeNode(node, node.val);
            }
        }
    }

    /**
     * 插入节点，成功返回true，已经存在返回false
     *
     * @param root
     * @param node
     * @return
     */
    public boolean insertNode(TreeNode root, TreeNode node){
        if(root == null){
            root = node;
            return true;
        }
        if(root.val > node.val){
            if(root.left == null){
                root.left = node;
                node.parent = root;
            }else{
                return insertNode(root.left, node);
            }
        }else if(root.val < node.val){
            if(root.right == null){
                root.right = node;
                node.parent = root;
            }else{
                return insertNode(root.right, node);
            }
        }else if(root.val == node.val){
            return false;
        }
        return true;
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


    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        log.info("in ************{}", root.val);
        inOrder(root.right);
    }

    public void preOrder(TreeNode tree){
        if (tree!=null) {
            log.info("pre ************{}", tree.val);
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    public void postOrder(TreeNode tree) {
        if (tree!=null) {
            postOrder(tree.left);
            postOrder(tree.right);
            log.info("post ************{}", tree.val);
        }
    }
    
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode parent;
      TreeNode(int x) {
          val = x;
      }
  }
