package cn.bugstack.design.cuisine.impl;

import cn.bugstack.design.OrderAdapter;
import cn.bugstack.design.service.OrderService;

/**
 * Author: chs
 * Description: 内部订单服务适配器
 * CreateTime: 2024-10-07
 */
public class InsideOrderAdapterImpl implements OrderAdapter {

    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId) {
        return orderService.queryUserOrderCount(uId) <= 1;
    }
}
