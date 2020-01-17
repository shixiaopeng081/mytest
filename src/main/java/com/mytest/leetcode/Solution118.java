package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution118 {

    public static void main(String[] args) {
        Solution118 solution = new Solution118();

        List<List<Integer>> result = solution.generate(1);
        log.info("{}", result);

    }
    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0){
            return Collections.emptyList();
        }
        List<List<Integer>> allList = new ArrayList<>();
        for(int i = 1;i<= numRows; i++){
            List<Integer> intList = new ArrayList<>();
            intList.add(1);
            if(i==2){
                intList.add(1);
            }else if(i >= 3){
                List<Integer> list = allList.get(i - 2);
                for(int j = 0;j+1 <list.size();j++){
                    intList.add(list.get(j)+list.get(j+1));
                }
                intList.add(1);
            }
            allList.add(intList);
        }
        return allList;
    }
}

