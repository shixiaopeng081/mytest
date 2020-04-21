package com.mytest.leetcode;

import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Created by shixi  on 2019/6/24
 */
@Slf4j
public class Solution1408 {

    public static void main(String[] args) {
        Solution1408 solution = new Solution1408();
        String[] nums = {"mass","as","hero","superhero"};

        log.info("i:{}",solution.stringMatching(nums));
    }
    public List<String> stringMatching(String[] words) {
        List<String> listStr = new ArrayList<>(Arrays.asList(words));

        Set<String> list = new HashSet<>();
        for(int i = 0;i < listStr.size(); i++){
            String s = listStr.get(i);

            List<String> strings = new ArrayList<>();
            strings.addAll(listStr);

            strings.remove(s);

            for(int k = 0;k<strings.size();k++){
                if(strings.get(k).contains(s)){
                    list.add(s);
                }
            }
        }

        return new ArrayList<>(list);
    }

    public List<String> stringMatching1(String[] words) {
        Set<String> list = new HashSet<>();

        String all = "";
        for(int i=0;i<words.length;i++){
            all =all +words[i]+",";
        }

        for(int i=0;i<words.length;i++){
            if(all.indexOf(words[i])!=all.lastIndexOf(words[i])){
                list.add(words[i]);
            }
        }


        return new ArrayList<>(list);
    }
}

