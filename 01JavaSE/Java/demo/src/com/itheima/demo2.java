package com.itheima;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo2 {
    public static void main(String[] args) throws ParseException {
        //1.格式化：Date-》string
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String s = sdf.format(date);
        System.out.println(s);

        //1.解析：String-》Date
        String date_s = "2023年04月12日 17:25:45";
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date d = sdf1.parse(date_s);
        System.out.println(d);
    }
}
