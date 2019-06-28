package com.mytest.offer;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by shixi  on 2019/6/21
 */
@Slf4j
public class ArrayFind1 {

    //从数组中找重复数字
    public static void main(String[] args) {
        int [] array = {2, 3, 1, 0, 2, 5, 3};
        //sortFind(array);
        swapFind(array);
    }

    //方法1：先排序，再寻找重复数字
    public static void sortFind(int [] array){
        Arrays.sort(array);
        log.info("array : {}", array);

        for(int i=0; i< array.length -1 ;i++){
            if(array[i] == array[i+1]){
                log.info("重复的数字 ：{}", array[i]);
            }
        }
    }

    //方法2：交换查找
    public static void swapFind(int [] array){
        List<Integer> integerList = new ArrayList<>();
        for(int i=0; i< array.length ;i++){
            log.info("i ----------------{}", i);

            while(array[i] != i){
                log.info("array[i] ----------------{}", array[i]);
                if(array[i] == array[array[i]]){
                    log.info("重复的数字 ：{}", array[i]);
                    integerList.add(array[i]);
                    break;
                }else{
                    int temp = array[i];
                    array[i] = array[temp];
                    array[temp] = temp;
                    log.info("array : {}", array);
                }

            }
        }

    }
}
