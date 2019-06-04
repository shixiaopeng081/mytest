package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2019/6/4
 */
public class QuickSort1 {

    public static void main(String[] args) {

        int [] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        recursion(arr, 0, arr.length - 1);
    }

    public static int sortArr(int [] arr, int low, int hei){
        if(low < hei){
            int temp = arr[low];
            int lowIndex = low;
            while(low < hei){
                while(low < hei && arr[hei] >= temp ){
                    hei --;
                }
                while(low < hei && arr[low] <= temp){
                    low ++;
                }
                if(low < hei){
                    int exchange = arr[low];
                    arr[low] = arr[hei];
                    arr[hei] = exchange;
                }
            }
            //基数放入low位置，
            arr[lowIndex] = arr[low];
            arr[low] = temp;

            System.out.println(Arrays.toString(arr));
        }
        return low;
    }
    public static void recursion(int [] arr, int low, int hei){
        if(low < hei){
            int middle = sortArr(arr, low, hei);
            recursion(arr, low, middle - 1);
            recursion(arr, middle + 1, hei);
        }
    }
}
