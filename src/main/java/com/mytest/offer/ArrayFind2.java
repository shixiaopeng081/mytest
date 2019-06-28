package com.mytest.offer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by shixi  on 2019/6/21
 */
@Slf4j
public class ArrayFind2 {
    //不允许改变数组顺序，寻找重复数字

    public static void main(String[] args) {
        int [] array = {2, 3, 5, 4, 3, 2, 6, 7};
        methodFind(array);
    }

    public static void methodFind(int [] array){

        for(int i=0; i< array.length;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] == array[j]){
                    log.info("重复的数字 = {}", array[i]);
                }
            }
        }

        log.info("array = {}", array);
    }

}
