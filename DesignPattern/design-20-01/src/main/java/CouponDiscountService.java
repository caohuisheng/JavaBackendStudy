/**
 * Author: chs
 * Description: 优惠券折扣计算服务
 * CreateTime: 2024-10-19
 */
public class CouponDiscountService {

    /**
     * 计算优惠券折扣后的金额
     * @param couponType 优惠券类型
     * @param couponAmount 优惠券金额
     * @param skuPrice 商品价格
     * @param couponExt 优惠券扩展
     * @return 扣减后的价格
     */
    public double discountAmount(int couponType, double couponAmount, double skuPrice, double couponExt){
        /**
         * 1.直减 2.满减 3.折扣 4。N元购
         */
        switch(couponType){
            case 1:return skuPrice - couponAmount;
            case 2:return skuPrice < couponExt ? skuPrice : skuPrice - couponAmount;
            case 3:return skuPrice * couponAmount;
            case 4:return couponAmount;
            default: return 0;
        }
    }

}
