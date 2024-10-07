package cn.bugstack.design.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Author: chs
 * Description: 订单服务
 * CreateTime: 2024-10-07
 */
public class OrderService {

    private Logger log = LoggerFactory.getLogger(OrderService.class);

    public long queryUserOrderCount(String userId){
        log.info("自营商家，查询用户的订单是否为首单：{}",userId);
        return 10L;
    }

}
