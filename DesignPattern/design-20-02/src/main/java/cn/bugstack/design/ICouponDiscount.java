package cn.bugstack.design;

import java.math.BigDecimal;

/**
 * Author: chs
 * Description: 优惠券折扣计算接口
 * CreateTime: 2024-10-19
 */
public interface ICouponDiscount<T> {

    /**
     * 优惠券扣减计算
     * @param couponInfo 优惠券信息
     * @param skuPrice sku价格
     * @return 扣减后金额
     */
    BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice);

}
