package com.itheima;


import java.util.Calendar;
import java.util.Scanner;

public class CalendarTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("年份:\n");
        int year = sc.nextInt();
        Calendar c = Calendar.getInstance();
        c.set(year,2,1);
        c.add(Calendar.DATE,-1);
        int days = c.get(Calendar.DATE);
        System.out.println(year+"二月年天数："+days);
    }
}
