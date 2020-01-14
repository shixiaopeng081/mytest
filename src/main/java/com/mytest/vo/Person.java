package com.mytest.vo;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by shixi  on 2020/1/8
 */
@Data

@Builder
@Slf4j
public class Person{
    private String name;
    private Integer sex;
}
