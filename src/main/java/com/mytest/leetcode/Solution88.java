package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution88 {

    public static void main(String[] args) {
        Solution88 solution = new Solution88();
        int[] nums1 = {0,0,0};
        int[] nums2 = {1,1,2};
        solution.merge2(nums1, 0, nums2, 3);
        log.info("{}", nums1);

    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums2.length == 0){
            return;
        }
        int i = 0;
        int j = 0;
        int [] all = new int[nums1.length];
        int k = 0;
        while(i < m && j < n){

            if(nums1[i] == nums2[j]){
                all[k] = nums1[i];
                k++;
                all[k] = nums1[i];
                k++;
                i++;
                j++;
            }else if(nums1[i] > nums2[j]){
                all[k] = nums2[j];
                k++;
                j++;
            }else if(nums1[i] < nums2[j]){
                all[k] = nums1[i];
                k++;
                i++;
            }

        }
        while(i >= m && j < n){
            all[k] = nums2[j];
            k++;
            j++;
        }
        while(j >= n && i < m){
            all[k] = nums1[i];
            k++;
            i++;
        }

        System.arraycopy(all, 0,  nums1,0, all.length);
    }

    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m -1;
        int j = n -1;
        int p = m + n -1;
        while(i>=0 && j >= 0){
            nums1[p--] =  nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        System.arraycopy(nums2,0,nums1,0,j+1);
        log.info("{}", nums1);
    }
}

