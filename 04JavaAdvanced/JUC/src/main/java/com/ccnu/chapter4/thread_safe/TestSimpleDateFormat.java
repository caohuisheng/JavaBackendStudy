package com.ccnu.chapter4.thread_safe;

import lombok.extern.slf4j.Slf4j;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: chs
 * Description: 测试SimpleDateFormat是否线程安全
 * CreateTime: 2024-08-03
 */
@Slf4j
public class TestSimpleDateFormat {

    public void bar(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        foo(sdf);
    }

    public void foo(SimpleDateFormat sdf){
        String dateStr = "2003-01-16 00:00:00";
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                try {
                    Date date = sdf.parse(dateStr);
                    log.info("result:{}", date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        new TestSimpleDateFormat().bar();
    }
}
