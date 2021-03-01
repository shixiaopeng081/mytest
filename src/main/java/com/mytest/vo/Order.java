package com.mytest.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by shixi  on 2020/6/28
 */
@Data
public class Order {
    /**
     * 订单来源
     */
    private String source;
    /**
     * 支付方式
     */
    private String payMethod;
    /**
     * 订单编号
     */
    private String code;
    /**
     * 订单金额
     */
    private BigDecimal amount;
    // ...其他的一些字段
}
