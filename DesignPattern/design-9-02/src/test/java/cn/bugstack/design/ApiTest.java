package cn.bugstack.design;

import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-10
 */
public class ApiTest {

    @Test
    public void test_LoginSsoDecorator() {
        LoginSsoDecorator loginSsoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        boolean success = loginSsoDecorator.preHandle("1successhuahua", "qwertyuiop", "t");
        System.out.println("测试结果：" + (success ? "通过" : "拦截"));
    }

}
