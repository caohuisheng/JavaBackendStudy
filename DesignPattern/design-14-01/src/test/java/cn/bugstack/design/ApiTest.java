package cn.bugstack.design;

import org.junit.Test;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-14
 */
public class ApiTest {

    @Test
    public void test(){
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.order(1);
        xiaoEr.order(2);
        xiaoEr.order(3);
        xiaoEr.order(4);

        //下单
        xiaoEr.placeOrder();
    }

}
