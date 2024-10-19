package cn.bugstack.design.impl;

import cn.bugstack.design.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Author: chs
 * Description: 折扣
 * CreateTime: 2024-10-19
 */
public class ZKCouponDiscount implements ICouponDiscount<Double> {

    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        //sku价格乘以折扣，且最终金额不能小于1
        BigDecimal discountAmount = skuPrice.multiply(new BigDecimal(couponInfo)).setScale(2, BigDecimal.ROUND_HALF_UP);
        return discountAmount.compareTo(BigDecimal.ONE) < 1 ? BigDecimal.ONE : discountAmount;
    }

}
