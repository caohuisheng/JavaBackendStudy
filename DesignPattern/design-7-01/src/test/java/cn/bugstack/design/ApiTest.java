package cn.bugstack.design;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-07
 */
public class ApiTest {

    @Test
    public void test_PayController(){
        PayController payController = new PayController();
        //微信支付、人脸方式
        payController.doPay("10001","204810071732",new BigDecimal("100.28"),1,2);
        //支付宝支付、指纹方式
        payController.doPay("10001","204810071734",new BigDecimal("102.38"),2,3);
    }

}
