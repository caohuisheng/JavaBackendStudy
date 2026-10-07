package com.ccnu.chapter6;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Author: chs
 * Description: 字段更新器
 * CreateTime: 2024-08-10
 */
public class FieldUpdater {
    private static FieldUpdater fieldUpdaterTest;
    private volatile int field;

    public static void main(String[] args) {
        FieldUpdater fieldUpdaterTest = new FieldUpdater();
        AtomicIntegerFieldUpdater<FieldUpdater> fieldUpdater = AtomicIntegerFieldUpdater.newUpdater(FieldUpdater.class, "field");
        fieldUpdater.compareAndSet(fieldUpdaterTest, 0, 10);
        System.out.println(fieldUpdaterTest.field);
        fieldUpdater.compareAndSet(fieldUpdaterTest, 0, 20);
        System.out.println(fieldUpdaterTest.field);
    }
}
