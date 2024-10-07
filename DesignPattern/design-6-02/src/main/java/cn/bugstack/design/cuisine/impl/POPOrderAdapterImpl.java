package cn.bugstack.design.cuisine.impl;

import cn.bugstack.design.OrderAdapter;
import cn.bugstack.design.service.POPOrderService;

/**
 * Author: chs
 * Description: 外部订单服务适配器
 * CreateTime: 2024-10-07
 */
public class POPOrderAdapterImpl implements OrderAdapter {

    private POPOrderService popOrderService = new POPOrderService();

    @Override
    public boolean isFirst(String uId) {
        return popOrderService.queryUserOrderCount(uId);
    }
}
