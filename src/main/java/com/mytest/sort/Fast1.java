package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2018/11/27
 */
public class Fast1 {


    public static void main(String[] args) {
        int []  ints = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};//{4,8,12,6,5,9,1};
        recursion(ints, 0 ,ints.length - 1);
        System.out.println("*****************6, 1, 2, 7, 9, 3, 4, 5, 10, 8****************************");
        int [] intss =  {5,7,1,9,3,2,8,6,-5,10,88};//{4,8,12,6,5,9,1};
        quickSort(intss, 0 ,ints.length - 1);
    }

    public static int getMiddle(int []  ints,int low, int height){
        int temp = ints[low];
        while(height > low){
            while(height > low && ints[height] > temp){
                height --;
            }
            ints[low] = ints[height];
            low ++;
            while(height > low && ints[low] < temp){
                low ++;
            }
            ints[height] = ints[low];
        }
        ints[low] = temp;
        System.out.println(Arrays.toString(ints));
        return low;
    }

    public static void recursion(int []  ints,int low, int height){
        if(height > low){
            int middle = getMiddle(ints, low, height);
            recursion(ints, low, middle - 1);
            recursion(ints, middle + 1, height);
        }
    }


    public static void quickSort(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>=high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }
        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;

        System.out.println(Arrays.toString(arr));
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

}
