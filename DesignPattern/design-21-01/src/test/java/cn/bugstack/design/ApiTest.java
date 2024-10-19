package cn.bugstack.design;

import cn.bugstack.design.impl.JingDongNetMall;
import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class ApiTest {

    @Test
    public void test(){
        NetMall netMall = new JingDongNetMall("100001", "******");
        String base64 = netMall.generateGoodsPoster("https://www.baidu.com");
        System.out.println("测试结果：" + base64);
    }

}
