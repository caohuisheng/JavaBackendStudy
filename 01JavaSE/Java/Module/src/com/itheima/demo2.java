package com.itheima;

import com.itheima.demo7.MyService;

import java.util.ServiceLoader;

public class demo2 {
    public static void main(String[] args) {
        //加载服务
        ServiceLoader<MyService> myServices = ServiceLoader.load(MyService.class);
        System.out.println(myServices);

        //遍历服务
        for(MyService ser:myServices){
            ser.service();
        }
    }
}
