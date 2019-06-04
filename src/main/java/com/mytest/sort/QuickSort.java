package com.mytest.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shixi  on 2019/5/31
 */
public class QuickSort {


    public static void main(String[] args) {
        int arr [] = {5,7,1,9,3,2,8,6,-5,10,88};
        recursion(arr, 0, arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    public static void recursion(int arr [], int low ,int heigth){
        if(low < heigth){
            int middle = quickSortMethod(arr, low, heigth);
            recursion(arr, low, middle -1);
            recursion(arr, middle + 1, heigth);
        }
    }

    public static int  quickSortMethod( int arr [], int low ,int heigth){
//        if(low >=heigth){
//            return low;
//        }
        int temp = arr[low];
        int flag = low;
        while(low < heigth){
            while(low < heigth && arr[heigth] >= temp){
                heigth --;
            }
            while(low < heigth && arr[low] <= temp){
                low ++;
            }
            if(low < heigth){
                int arg = arr[heigth];
                arr[heigth] = arr[low];
                arr[low] = arg;
            }
        }
        //temp = arr[low];
        int middle = arr[low];
        arr[low] = temp;
        arr[flag] = middle;
        System.out.println(Arrays.toString(arr));
        System.out.println("low================="+low);

        return low;
    }
}
