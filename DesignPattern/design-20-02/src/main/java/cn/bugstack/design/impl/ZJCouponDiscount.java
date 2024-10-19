package cn.bugstack.design.impl;

import cn.bugstack.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: 直减
 * CreateTime: 2024-10-19
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {

    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        //直减n元，且最终金额不能小于1
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        return discountAmount.compareTo(BigDecimal.ONE) < 1 ? BigDecimal.ONE : discountAmount;
    }

}
