package cn.bugstack.design;

import cn.bugstack.design.channel.Pay;
import cn.bugstack.design.channel.WxPay;
import cn.bugstack.design.channel.ZfbPay;
import cn.bugstack.design.mode.CypherPayMode;
import cn.bugstack.design.mode.FacePayMode;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-07
 */
public class ApiTest {

    @Test
    public void test_Pay(){
        Pay wxPay = new WxPay(new CypherPayMode());
        wxPay.transfer("10001","204810071753",new BigDecimal("128.89"));
        Pay zfbPay = new ZfbPay(new FacePayMode());
        zfbPay.transfer("10001","204810071754",new BigDecimal("138.89"));
    }

}
