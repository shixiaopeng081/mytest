package com.mytest.handler;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * Created by shixi  on 2020/6/28
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Service
public @interface OrderHandlerType {
    String source();
}
