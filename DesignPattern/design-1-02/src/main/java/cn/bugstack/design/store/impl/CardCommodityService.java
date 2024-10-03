package cn.bugstack.design.store.impl;

import cn.bugstack.design.store.ICommodity;
import cn.bugstack.design.card.IQiYiCardService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-04
 */
public class CardCommodityService implements ICommodity {

    private Logger log = LoggerFactory.getLogger(CardCommodityService.class);

    private IQiYiCardService iQiYiCardService = new IQiYiCardService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        iQiYiCardService.grantToken(queryUserPhoneNumber(uId), commodityId);
        log.info("请求参数[爱奇艺兑换卡]：uId:{} commodityId:{} bizId:{} extMap:{}", uId, commodityId, bizId, extMap);
        log.info("测试结果[爱奇艺兑换卡]：success");
    }

    private String queryUserPhoneNumber(String uId){
        return "18171318816";
    }
}
