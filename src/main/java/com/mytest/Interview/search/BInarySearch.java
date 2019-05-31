package com.mytest.Interview.search;

import java.util.Arrays;

/**
 * @author shixiaopeng
 * 二分查找
 */
public class BInarySearch {

    public static void main(String[] args) {

        int [] arrays = {2, 4, 5, 7, 9, 12, 17, 18, 26, 32, 50, 68, 75};

        recursion(arrays,5);

        noRecursion(arrays, 0, arrays.length - 1, 5);
    }

    //递归
    public static void recursion(int [] arrays, int arg){
        int length = arrays.length;
        if(length == 0){
            return;
        }else if(length ==1){
            if(arrays[0] == arg){
                System.out.println("找到" + arg);
            }
            return;
        }
        int min = arrays[0];
        int max = arrays[length - 1];

        if(min == arg){
            System.out.println("min找到" + arg);
        }else if(max == arg){
            System.out.println("max找到" + arg);
        }else if(min < arg && arg < max){
            int middle = arrays[length/2];

            if(middle == arg){
                System.out.println("middle找到" + arg);
            }else if(middle > arg){
                recursion(Arrays.copyOfRange(arrays,0,length/2),arg);
            }else{
                recursion(Arrays.copyOfRange(arrays,length/2+1,length),arg);
            }
        }

    }


    //非递归
    public static void noRecursion(int [] arrays, int min, int max, int arg){

        int i = 0;
        while(min <= max){
            System.out.println("i=============="+i);
            if(arrays[min] > arg){
                break;
            }
            if(arrays[max] < arg){
                break;
            }
            if(arrays[min] == arg){
                System.out.println("min找到");
                break;
            }
            if(arrays[max] == arg){
                System.out.println("max找到");
                break;
            }

            int middle = (min + max) / 2;
            if(arrays[middle] == arg){
                System.out.println("middle找到");
                break;
            }else if(arrays[middle] > arg){
                max = middle - 1;
            }else{
                min = middle + 1;
            }

            i ++;
        }

    }
}
