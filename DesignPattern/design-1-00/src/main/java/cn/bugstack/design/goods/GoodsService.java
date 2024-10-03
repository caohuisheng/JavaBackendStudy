package cn.bugstack.design.goods;

import com.alibaba.fastjson.JSON;

/**
 * Author: chs
 * Description: 模拟发放实物商品
 * CreateTime: 2024-10-03
 */
public class GoodsService {

    public Boolean deliverGoods(DeliverReq req){
        System.out.println("模拟发放实物商品一个：" + JSON.toJSONString(req));
        return true;
    }

}
