package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2018/11/27
 */
public class Heap4 {

    public static void main(String[] args) {
        int [] arr = {5,4,6,8,9,1,7};

        //创建堆
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
            System.out.println(Arrays.toString(arr));
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
//            adjustHeap(arr, 0, i);
        }

        System.out.println(Arrays.toString(arr));
    }

    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int left = 2 * parent + 1;

        while (left < length) {
            //右孩子
            int right = left + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (right < length && arr[left] < arr[right]) {
                left++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[left]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[left];

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = left;
            left = 2 * left + 1;
        }
        arr[parent] = temp;
    }
}
