package com.itheima.demo3;

import java.util.function.Supplier;

public class SupplierTest {
    public static void main(String[] args) {

    }

    private int getMax(Supplier<Integer> sup){
        return sup.get();
    }
}
