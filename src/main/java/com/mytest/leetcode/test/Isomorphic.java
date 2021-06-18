package com.mytest.leetcode.test;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class Isomorphic {

    public static void main(String[] args) {
        Isomorphic isomorphic = new Isomorphic();
        String s = "badc", t = "baba";
        boolean b = isomorphic.isIsomorphic(s, t);
        log.info("{}", b);
    }

    public boolean isIsomorphic(String s, String t) {

        char[] charsS = s.toCharArray();
        char[] charsT = t.toCharArray();
        Map<String, String> mapS = new HashMap<>();
        Map<String, String> mapT = new HashMap<>();
        for (int i = 0; i< charsS.length; i++){
            String s1 = mapS.get(charsS[i]+"");
            if(s1 == null){
                mapS.put(charsS[i]+"", charsT[i]+"");
            }
            if(s1 != null && !s1.equals(charsT[i]+"")){
                return false;
            }
            String t1 = mapT.get(charsT[i]+"");
            if(t1 == null){
                mapT.put(charsT[i]+"", charsS[i]+"");
            }
            if(t1 != null && !t1.equals(charsS[i]+"")){
                return false;
            }
        }
        return true;
    }
}
