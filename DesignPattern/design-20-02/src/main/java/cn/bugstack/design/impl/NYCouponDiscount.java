package cn.bugstack.design.impl;

import cn.bugstack.design.ICouponDiscount;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: N元购
 * CreateTime: 2024-10-19
 */
public class NYCouponDiscount implements ICouponDiscount<Double> {

    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        //N元购
        return new BigDecimal(couponInfo);
    }

}
