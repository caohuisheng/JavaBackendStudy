package cn.bugstack.design;

import cn.bugstack.design.card.IQiYiCardService;
import cn.bugstack.design.coupon.CouponResult;
import cn.bugstack.design.coupon.CouponService;
import cn.bugstack.design.goods.DeliverReq;
import cn.bugstack.design.goods.GoodsService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Author: chs
 * Description:
 * CreateTime: 2024-10-03
 */
public class PrizeController {

    private Logger log = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUser(AwardReq req){
        String reqStr = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try {
            log.info("奖品发放开始 req:{}", reqStr);
            if(req.getAwardType() == 1){
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getuId(), req.getAwardNumber(), req.getBizId());
                if("0000".equals(couponResult.getCode())) awardRes = new AwardRes("0000", "发放成功");
                else awardRes = new AwardRes("0001", couponResult.getInfo());
            }else if(req.getAwardType() == 2){
                Map<String, String> extMap = req.getExtMap();
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUsername(req.getuId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(extMap.get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(extMap.get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(extMap.get("consigneeUserAddress"));
                Boolean success = goodsService.deliverGoods(deliverReq);
                if(success) awardRes = new AwardRes("0000", "发放成功");
                else awardRes = new AwardRes("0001", "发放失败");
            }else if(req.getAwardType() == 3){
                String bindMobileNumber = queryUserPhoneNumber(req.getuId());
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken(bindMobileNumber, req.getBizId());
                awardRes = new AwardRes("0000", "发放成功");
            }
        } catch (Exception e) {
            log.error("奖品发放失败 req:{}", reqStr, e);
            awardRes = new AwardRes("0001", e.getMessage());
        }
        return awardRes;
    }

    private String queryUsername(String uId){
        return "林更新";
    }

    private String queryUserPhoneNumber(String uId){
        return "18171318816";
    }
}
