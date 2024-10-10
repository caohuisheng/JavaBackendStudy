package cn.bugstack.design;

import cn.bugstack.design.channel.Pay;
import cn.bugstack.design.channel.WxPay;
import cn.bugstack.design.channel.ZfbPay;
import cn.bugstack.design.mode.CypherPayMode;
import cn.bugstack.design.mode.FacePayMode;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) {
        int[] arr = new int[10];
        Set<Integer> s = new HashSet<>();
        Integer[] integers = s.toArray(new Integer[0]);
    }

}
