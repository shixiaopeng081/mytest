package com.mytest.handler;

import com.mytest.vo.Order;

/**
 * Created by shixi  on 2020/6/28
 */
@OrderHandlerType(source = "mobile")
public class MobileOrderHandler implements OrderHandler {
    @Override
    public void handle(Order order) {
        System.out.println("处理移动端订单");
    }
}
