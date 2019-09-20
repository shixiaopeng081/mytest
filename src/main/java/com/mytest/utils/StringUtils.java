package com.mytest.utils;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2019/9/17
 */
@Slf4j
public class StringUtils {

    public static void main(String[] args) {
        String str = "https://h5.gdt.qq.com/xjviewer/nemo/1018602?_wv=1";

        log.info("{}", str.lastIndexOf("/"));
        log.info("{}", str.indexOf("?"));

        log.info("{}", str.substring(str.lastIndexOf("/")+1, str.indexOf("?")));
    }
}
