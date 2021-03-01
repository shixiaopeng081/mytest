package com.mytest.handler;

import com.mytest.vo.Order;

/**
 * Created by shixi  on 2020/6/28
 */
@OrderHandlerType(source = "pc")
public class PCOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("处理PC端订单");
    }
}