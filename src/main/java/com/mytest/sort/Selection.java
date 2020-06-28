package com.mytest.sort;

import java.util.Arrays;

/**
 * 选择排序
 * Created by shixi  on 2018/11/26
 */
public class Selection {

    public static void main(String[] args) {
        int score[] = {6, 4, 3, 8, 7, 2,0,9};//{9,8,7,6,5,4,3,2,1};//
        for (int i = 0; i < score.length; i++) {
            int min = i;
            for (int j = i+1; j < score.length; j++) {
                if (score[i] > score[j]) {
                    min = j;
                }
            }
            int tmp = score[min];
            score[min] = score[i];
            score[i] = tmp;

        }

        System.out.println(Arrays.toString(score));
    }
}
