package com.mytest.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shixi  on 2018/11/23
 */
public class Heap1 {
    public static void main(String[] args) {
        Integer [] newInts = {};

        Integer [] ints = {5,3,7,8,1,4,9,6};

        List<Integer> result = new ArrayList<>();

        int size = ints.length;
        //外层循环，每循环一次，二叉树就少一个元素，因为把最大的值提出来了
        while(size>2){

            //堆排序
            //父节点个数，(n-1)/2，取整。那么父节点的索引就是，从（父节点个数）到（1）
            //子节点索引就是，左子节点索引=2*父节点索引，右子节点索引=左子节点索引+1

            //循环父节点个数---功能就是找到最大的值,放在二叉树的顶端
            for(int i=(size - 1)/2; i>=1; i--){
                //先把左子节点索引作为做大的值的索引
                int maxIndex = i*2;

                //先左右比较，再和父节点比较

                if( maxIndex+1 < size && ints[maxIndex+1] > ints[maxIndex]){
                    //maxIndex = maxIndex+1;
                    int temp = ints[maxIndex+1];
                    ints[maxIndex+1] = ints[maxIndex];
                    ints[maxIndex] = temp;
                }
                //和父节点比较
                if(ints[maxIndex] > ints[i]){
                    int temp = ints[maxIndex];
                    ints[maxIndex] = ints[i];
                    ints[i] = temp;
                }

            }
            System.out.println(Arrays.toString(ints));
            List<Integer> integerList = new ArrayList<>(Arrays.asList(ints));
            result.add(integerList.get(1));
            integerList.remove(1);
            ints = integerList.toArray(new Integer[0]);
            size = ints.length;
        }


       // System.out.println(Arrays.toString(ints));
        System.out.println(result);
    }
}
