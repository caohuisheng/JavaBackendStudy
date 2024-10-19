package cn.bugstack.design;

import cn.bugstack.design.impl.MJCouponDiscount;
import cn.bugstack.design.impl.NYCouponDiscount;
import cn.bugstack.design.impl.ZJCouponDiscount;
import cn.bugstack.design.impl.ZKCouponDiscount;
import org.junit.Test;

import javax.swing.text.AbstractDocument;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-19
 */
public class ApiTest {

    @Test
    public void test(){
        //1.直减
        Context<Double> zjContext = new Context<>(new ZJCouponDiscount());
        BigDecimal zjAmount = zjContext.discountAmount(10D, new BigDecimal(100));
        System.out.println("直减后金额：" + zjAmount);

        //2.满减
        Context<Map<String, String>> mjContext = new Context<>(new MJCouponDiscount());
        Map<String, String> couponInfo = new HashMap<>();
        couponInfo.put("x", "100");
        couponInfo.put("n", "10");
        BigDecimal mjAmount = mjContext.discountAmount(couponInfo, new BigDecimal(100));
        System.out.println("满减后金额：" + mjAmount);

        //3.折扣
        Context<Double> zkContext = new Context<>(new ZKCouponDiscount());
        BigDecimal zkAmount = zkContext.discountAmount(0.85D, new BigDecimal(100));
        System.out.println("折扣后金额：" + zkAmount);

        //4.N元购
        Context<Double> nyContext = new Context<>(new NYCouponDiscount());
        BigDecimal nyAmount = nyContext.discountAmount(89D, new BigDecimal(100));
        System.out.println("N元购后金额：" + nyAmount);
    }

}
