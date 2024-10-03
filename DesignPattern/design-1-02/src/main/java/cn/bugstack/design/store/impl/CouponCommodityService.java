package cn.bugstack.design.store.impl;

import cn.bugstack.design.store.ICommodity;
import cn.bugstack.design.coupon.CouponResult;
import cn.bugstack.design.coupon.CouponService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class CouponCommodityService implements ICommodity {

    private Logger log = LoggerFactory.getLogger(CouponCommodityService.class);

    private CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        log.info("请求参数[优惠券]：uId:{} commodityId:{} bizId:{} extMap:{}", uId, commodityId, bizId, extMap);
        log.info("测试结果[优惠券]：{}", JSON.toJSONString(couponResult));
    }
}
