package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2018/11/26
 */
public class Heap2 {

    public static void main(String[] args) {
        Integer[] intArrays = {4, 9, 2, 6, 7, 1, 8, 5};

        int size = intArrays.length;
        //数组下标为0的，不参与排序。size必须大于等于3，不然组不成父节点和左右两个子节点
        while (size > 2) {
            //循环父节点，父节点个数，就是总节点数除2，取整。
            for(int i = (size-1)/2; i >= 1; i--){
                //左节点
                int leftNode = 2*i;
                int maxNode = leftNode;
                //右节点
                int rightNode = leftNode + 1;

                if(rightNode < size && intArrays[rightNode] > intArrays[leftNode]){
                    maxNode = rightNode;
                }

                if(intArrays[i] < intArrays[maxNode]){
                    //交换
                    int temp = intArrays[maxNode];
                    intArrays[maxNode] = intArrays[i];
                    intArrays[i] = temp;
                }
            }
            //内层循环已经找到最大值了，已放到跟节点了，父节点的值交换到最后一个
            int temp = intArrays[size -1];
            intArrays[size -1] = intArrays[1];
            intArrays[1] = temp;

            //现在最后一个节点为最大值，除了最后一个节点，重新排
            size --;
        }
        System.out.println(Arrays.asList(intArrays));
    }
}
