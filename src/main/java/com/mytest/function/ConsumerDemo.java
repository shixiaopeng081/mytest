package com.mytest.function;

import java.util.function.Consumer;

/**
 * Created by shixi  on 2021/3/15
 */
public class ConsumerDemo {

    public static void main(String[] args) {
        testConsumer(2, x -> System.out.println("传入的数字：" + x)); // 传入的数字：2
    }

    /**
     * 消费型接口，有输入，但是没返回值
     *
     * @param num
     * @param consumer
     * @return
     */
    public static void testConsumer(int num, Consumer<Integer> consumer) {
        consumer.accept(num);
    }
}
