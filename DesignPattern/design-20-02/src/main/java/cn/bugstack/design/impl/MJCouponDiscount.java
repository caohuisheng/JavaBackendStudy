package cn.bugstack.design.impl;

import cn.bugstack.design.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Author: chs
 * Description: 满减
 * CreateTime: 2024-10-19
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String, String>> {

    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        //满x元减n元，且最终金额不能小于1
        String x = couponInfo.get("x");
        String n = couponInfo.get("n");
        if(skuPrice.compareTo(new BigDecimal(x)) < 0) return skuPrice;
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(n));
        return discountAmount.compareTo(BigDecimal.ONE) < 1 ? BigDecimal.ONE : discountAmount;
    }

}
