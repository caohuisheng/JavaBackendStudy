package com.itheima;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class demo2 {
    public static void main(String[] args) {
        //将当前时间转换为指定格式
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = now.format(dateTimeFormatter);
        System.out.println(format);

        //将字符串解析为指定时间
        String s = "2023-04-26 22:29:20";
        LocalDateTime parse = LocalDateTime.parse(s, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        System.out.println(parse);
    }
}
