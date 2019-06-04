package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2019/6/4
 */
public class InsertSort {

    public static void main(String[] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1,0};
        insertMethod(arr);
        int [] arr1 = {9,8,7,6,5,4,3,2,1,0};
       maoMethod(arr1);
    }

    /**
     * 插入排序
     * @param arr
     */
    private static void insertMethod(int[] arr) {
        int flag = 0;
        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {

                if (arr[j] < arr[j - 1]) {
                    flag++;
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println("插入=="+flag);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序
     * @param arr
     */
    private static void maoMethod(int[] arr) {
        int flag = 0;

        for (int i = 0; i < arr.length-1; i++) {

            for (int j = 0; j < arr.length - i-1; j++) {

                if (arr[j] > arr[j + 1]) {
                    flag++;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println("冒泡=="+flag);
        System.out.println(Arrays.toString(arr));
    }
}
