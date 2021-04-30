package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2018/11/27
 */
public class Heap5 {

    public static void main(String[] args) {
        int [] arr = {5,4,6,8,9,1,7};

        //构建大顶堆
        int length = arr.length;
        for(int fatherNode = (length - 1)/2;fatherNode>= 0;fatherNode-- ){
            heapSort(arr, fatherNode, length);
        }

        //循环交换,定堆和最后一个元素交互
        for(int i=arr.length -1;i>0 ;i--){
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            heapSort(arr, 0,i);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int [] arr,int fatherNode, int length){



            int leftNode = 2*fatherNode +1;
            while(leftNode < length){
                int rightNode = leftNode +1;
                if(rightNode < length && arr[leftNode] < arr[rightNode] ){
                    leftNode++;
                }
                if(arr[fatherNode] >= arr[leftNode]){
                    break;
                }

                if(arr[fatherNode] < arr[leftNode]){
                    int temp = arr[fatherNode];
                    arr[fatherNode] = arr[leftNode];
                    arr[leftNode] = temp;

                    fatherNode = leftNode;
                    leftNode = 2*leftNode +1;
                }

            }
            System.out.println(Arrays.toString(arr));
    }

}
