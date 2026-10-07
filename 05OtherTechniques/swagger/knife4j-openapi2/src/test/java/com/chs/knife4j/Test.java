package com.chs.knife4j;

import java.util.Arrays;

/**
 * @author: chs
 * @date: 2025-12-04 10:51
 * @description: todo
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(Arrays.toString("aaa".split("\\?")));
        System.out.println(Arrays.toString("aaa?".split("\\?")));
    }
}