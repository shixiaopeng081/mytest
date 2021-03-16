package com.mytest.function;

import java.util.function.Supplier;

/**
 * Created by shixi  on 2021/3/15
 */
public class SupplierDemo {

    public static void main(String[] args) {
        String result = testSupplier(() -> "hello man!");
        System.out.println(result); // hello man!
    }

    /**
     * 供给型接口，无输入，有输出
     *
     * @param supplier
     * @return
     */
    public static String testSupplier(Supplier<String> supplier) {
        return supplier.get();
    }
}
