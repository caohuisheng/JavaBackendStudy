package com.ccnu.chapter7;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

/**
 * Author: chs
 * Description: 日期转换
 * CreateTime: 2024-08-11
 */
@Slf4j
public class DateTransform {

    //会有线程安全问题
    static void test1(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    log.info("date:{}", sdf.parse("2024-08-11"));
                } catch (ParseException e) {
                    log.error("{}",e);
                }
            }).start();
        }
    }

    //同步锁解决
    static void test2(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                synchronized(sdf){
                    try {
                        log.info("date:{}", sdf.parse("2024-08-11"));
                    } catch (ParseException e) {
                        log.error("{}",e);
                    }
                }
            }).start();
        }
    }

    //不可变类解决
    static void test3(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                LocalDate date = dtf.parse("2024-08-11", LocalDate::from);
                log.info("date:{}", date);
            }).start();
        }
    }

    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

}
