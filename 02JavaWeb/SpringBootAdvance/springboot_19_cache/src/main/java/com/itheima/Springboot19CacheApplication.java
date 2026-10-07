package com.itheima;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching //开启缓存
@EnableCreateCacheAnnotation //开启jetcache
public class Springboot19CacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot19CacheApplication.class, args);
    }

}
