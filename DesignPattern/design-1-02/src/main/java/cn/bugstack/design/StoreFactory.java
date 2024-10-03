package cn.bugstack.design;

import cn.bugstack.design.store.ICommodity;
import cn.bugstack.design.store.impl.CardCommodityService;
import cn.bugstack.design.store.impl.CouponCommodityService;
import cn.bugstack.design.store.impl.GoodsCommodityService;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class StoreFactory {

    public ICommodity getCommodityService(Integer commodityType){
        switch(commodityType){
            case 1:return new CouponCommodityService();
            case 2:return new GoodsCommodityService();
            case 3:return new CardCommodityService();
            default:throw new RuntimeException("不存在的发放商品类型！");
        }
    }
}
