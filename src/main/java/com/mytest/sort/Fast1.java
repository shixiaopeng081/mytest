package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2018/11/27
 */
public class Fast1 {


    public static void main(String[] args) {
        int []  ints = {4,8,12,6,5,9,1};
        recursion(ints, 0 ,ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    public static int getMiddle(int []  ints,int low, int height){
        int temp = ints[low];
        while(height > low){
            while(height > low && ints[height] > temp){
                height --;
            }
            ints[low] = ints[height];
            while(height > low && ints[low] < temp){
                low ++;
            }
            ints[height] = ints[low];
        }
        ints[low] = temp;
        return low;
    }

    public static void recursion(int []  ints,int low, int height){
        if(height > low){
            int middle = getMiddle(ints, low, height);
            recursion(ints, low, middle - 1);
            recursion(ints, middle + 1, height);
        }
    }
}
