package cn.bugstack.design;

import cn.bugstack.design.factory.JDKProxy;
import cn.bugstack.design.factory.impl.EGMCacheAdapter;
import cn.bugstack.design.factory.impl.IIRCacheAdapter;
import cn.bugstack.design.impl.CacheServiceImpl;
import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class ApiTest {

    @Test
    public void test_cacheService(){
        CacheService egm_proxy = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        egm_proxy.set("username","林更新");
        String username1 = egm_proxy.get("username");
        System.out.println("测试结果：" + username1);

        CacheService iir_proxy = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCacheAdapter());
        iir_proxy.set("username","霍建华");
        String username2 = iir_proxy.get("username");
        System.out.println("测试结果：" + username2);
    }
}
