package cn.bugstack.design;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-13
 */
public class ApiTest {

    @Test
    public void test_AuthController() throws ParseException {
        AuthController authController = new AuthController();
        String uId = "林更新";
        String orderId = "204820241013";

        System.out.println("当前审批流程节点:" + authController.doAuth(uId, orderId, new Date()));
        System.out.println("模拟三级负责人审批:张总");
        AuthService.auth("100013", orderId);

        System.out.println("当前审批流程节点:" + authController.doAuth(uId, orderId, new Date()));
        System.out.println("模拟二级负责人审批:刘总");
        AuthService.auth("100012", orderId);

        System.out.println("当前审批流程节点:" + authController.doAuth(uId, orderId, new Date()));
        System.out.println("模拟一级负责人审批:李总");
        AuthService.auth("100011", orderId);
    }

}
