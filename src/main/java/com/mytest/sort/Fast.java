package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2018/11/26
 */
public class Fast {
    public static void main(String[] args) {

       int score[] = {6,3,7,4,1};//{10,-9,6, 4, 3,-1,  8, 7, 2,9};
       recursion(score, 0, score.length-1);
      // System.out.println(Arrays.toString(score));
    }

    //快速排
    public static int quicklySort(int [] score , int low ,int hei){
        int temp = score[low];

        while(low < hei){
            while(low < hei && score[hei] > temp){//把score[hei] > temp改为score[hei] < temp,则为降序
                hei --;
            }
            score[low] = score[hei];
            while(low < hei && score[low] < temp){//把score[low] < temp改为score[low] > temp,则为降序
                low ++ ;
            }
            score[hei] =score[low];
            System.out.print(hei);
            System.out.println("     "+low);
            System.out.println(Arrays.toString(score));
        }
        score[low] = temp;
        System.out.println(Arrays.toString(score));
        return low;
    }

    public static void recursion(int [] score , int low ,int hei){
        if(low  < hei){
            int middle = quicklySort(score, low, hei);
//            recursion(score , low ,middle-1);
//            recursion(score , middle+1 , hei);
        }
    }
}
