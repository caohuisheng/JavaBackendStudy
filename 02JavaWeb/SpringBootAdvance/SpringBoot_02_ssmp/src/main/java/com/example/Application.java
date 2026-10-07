package com.example;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.logging.Logger;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(args));
        //SpringApplication.run(Application.class, args);
        System.out.println("aaa");

        // 通过系统设置关闭热部署
        System.setProperty("spring.devtools.restart.enabled","false");
        SpringApplication.run(Application.class);   //可以不传参数，防止用户修改
    }

}
