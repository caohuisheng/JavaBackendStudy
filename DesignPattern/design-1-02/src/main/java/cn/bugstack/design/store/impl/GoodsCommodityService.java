package cn.bugstack.design.store.impl;

import cn.bugstack.design.store.ICommodity;
import cn.bugstack.design.goods.DeliverReq;
import cn.bugstack.design.goods.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class GoodsCommodityService implements ICommodity {

    private Logger log = LoggerFactory.getLogger(GoodsCommodityService.class);

    private GoodsService goodsService = new GoodsService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        DeliverReq req = new DeliverReq();
        req.setUserName(queryUsername(uId));
        req.setUserPhone(queryUserPhoneNumber(uId));
        req.setOrderId(commodityId);
        req.setSku(bizId);
        req.setConsigneeUserName(extMap.get("consigneeUserName"));
        req.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
        req.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));
        Boolean success = goodsService.deliverGoods(req);

        log.info("请求参数[实物奖品]：uId:{} commodityId:{} bizId:{} extMap:{}", uId, commodityId, bizId, extMap);
        log.info("测试结果[实物奖品]：{}", success);
    }

    private String queryUsername(String uId){
        return "林更新";
    }

    private String queryUserPhoneNumber(String uId){
        return "18171318816";
    }
}
