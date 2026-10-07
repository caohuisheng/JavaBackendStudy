package com.itheima;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class demo1 {
    public static void main(String[] args) {
        //T表示时间的开始，精确到纳秒
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        LocalDateTime of = LocalDateTime.of(2022, 10, 11, 9, 20, 10);
        System.out.println(of);
    }
}
