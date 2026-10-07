package com.itheima.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyBean {

    //使用注解配置定时任务
    @Scheduled(cron = "0/1 * * * * ?")
    public void print(){
        System.out.println("task is running...");
    }
}
