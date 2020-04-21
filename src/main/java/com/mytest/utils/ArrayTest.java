package com.mytest.utils;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2020/2/21
 */
@Slf4j
public class ArrayTest {


    public static void main(String[] args) {
        String s = "212121,324343,54545,7676,87878";
        String[] split = s.split(",");

        Long[] ff = {2121L,2121212L,22323L};

        JSONArray.toJSONString(split);
        log.info(JSONArray.toJSONString(split));
        log.info(JSONArray.toJSONString(ff));
    }
}
