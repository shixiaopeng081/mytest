package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution108 {

    public static void main(String[] args) {
        Solution108 solution = new Solution108();

        TreeNode result = solution.sortedArrayToBST(new int[]{3,4,6,7,8,9});
        log.info("{}", result);

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start == end) {
            return null;
        }
        int mid = (start + end) >>> 1;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid);
        root.right = sortedArrayToBST(nums, mid + 1, end);

        return root;
    }
}

