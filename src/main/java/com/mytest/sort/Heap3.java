package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2018/11/27
 */
public class Heap3 {

    public static void main(String[] args) {
        int [] intArray = {5,4,6,8,9,1,7};

        int length = intArray.length;
        while(length > 2){
            //循环父节点，
            for (int i = (length -1)/2;i > 0;i -- ){
                //左节点
                int left = 2*i;
                int max = left;
                //右节点
                int right = left + 1;

                if(right < length && intArray[right] > intArray[left]){
                    max = right;
                }

                if(intArray[max] > intArray[i]){
                    int temp = intArray[max];
                    intArray[max] = intArray[i];
                    intArray[i] = temp;
                }
            }
            int temp = intArray[1];
            intArray[1] = intArray[length - 1];
            intArray[length - 1] = temp;

            length --;
        }

        System.out.println(Arrays.toString(intArray));
    }
}
