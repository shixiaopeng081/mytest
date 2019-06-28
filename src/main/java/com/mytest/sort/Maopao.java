package com.mytest.sort;

import java.util.Arrays;

/**
 * Created by shixi  on 2018/11/26
 */
public class Maopao {

    public static void main(String[] args) {
        int score[] = {6, 4, 3, 8, 7, 2,0,9};//{9,8,7,6,5,4,3,2,1};//
        for (int i = 0; i < score.length - 1; i++) {    //最多做n-1趟排序
            for (int j = 0; j < score.length - i - 1; j++) {    //对当前无序区间score[0......length-i-1]进行排序(j的范围很关键，这个范围是在逐步缩小的)
                if (score[j] > score[j + 1]) {    //把大的值交换到后面
                    int temp = score[j];
                    score[j] = score[j + 1];
                    score[j + 1] = temp;
                }
            }
            System.out.println(Arrays.toString(score));
        }
    }
}
