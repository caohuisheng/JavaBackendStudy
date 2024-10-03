package cn.bugstack.design.coupon;

/**
 * Author: chs
 * Description: 模拟发放优惠卷服务
 * CreateTime: 2024-10-03
 */
public class CouponService {

    public CouponResult sendCoupon(String uid, String couponNumber, String uuid){
        System.out.println("模拟发放优惠劵一张：" + uid + ", " + couponNumber + ", " + uuid);
        return new CouponResult("0000","发放成功");
    }

}
