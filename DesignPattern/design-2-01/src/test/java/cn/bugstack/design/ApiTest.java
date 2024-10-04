package cn.bugstack.design;

import cn.bugstack.design.cuisine.impl.CacheServiceImpl;
import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class ApiTest {

    @Test
    public void test_cacheService(){
        CacheService cacheService = new CacheServiceImpl();
        cacheService.set("username","林更新",1);
        String username = cacheService.get("username", 1);
        System.out.println("测试结果："+username);
    }
}
